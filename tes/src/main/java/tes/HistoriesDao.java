package tes;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

public class HistoriesDao extends ConnectionDao {
	
	public HistoriesDao() throws Exception {
		//question
		setConnection();
	}
	public void Insert(HistoriesBean Bean) throws DAOException, Exception {
		//データベースに接続されているかの判定
		if (con == null) {
			//データベースに接続する
			setConnection();
		}//実行前の準備
		PreparedStatement st = null;
		//sql実行結果の格納
		ResultSet rs = null;
		try {
			//insertでquestionテーブルのquestionの中身を入力できる処理
			
			//questionテーブルのレコード追加処理。またcurrent_timestamp()を使うことで現在時間も取得している
			String sql = "INSERT INTO histories ( user_id, point, created_at) values (?,?,current_timestamp());";
			/** PreparedStatement オブジェクトの取得**/
			st = con.prepareStatement(sql);
			//入力の中身をセットさせる
			//一つ目の「?」にquestionを置換
			st.setInt(1, Bean.getUserId());
			st.setInt(2, Bean.getPoint());
			/** SQL 実行 **/
			st.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("レコードの取得に失敗しました");
		//例外が発生しcatchされなくても必ず行われる処理
		} finally {
			try {
				//sqlの実行結果をcloseしている
				if (rs != null) {
						rs.close();
				}
				if (st != null) {
						st.close();
				}
				//ConnectionDaoのcloseを呼び出している
				close();
				} catch (Exception e){
					e.printStackTrace();
				throw new DAOException("リソースの開放に失敗しました");
				}
			}
		}
	public ArrayList<HistoriesBean> findAll(String user_id) throws DAOException, Exception {
		if (con == null) {
			setConnection();
		}
		
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			//order by created_atで昇順で並び替えをする。
			String sql = "SELECT  user_id, point, created_at FROM histories order by created_at where user_id = ? ;";
			/** PreparedStatement オブジェクトの取得**/
			st = con.prepareStatement(sql);
			/** SQL 実行 **/
			//Sessionのuser_idとつなげる
			st.setString(1,user_id);
			rs = st.executeQuery();
			/** select文の結果 vをArrayListに格納 **/
			ArrayList<HistoriesBean> list = new ArrayList<HistoriesBean>();
			while (rs.next()) {
			
				int users_id = rs.getInt("user_id");
				int point = rs.getInt("point");
				
				
				
				
				Timestamp created_at = rs.getTimestamp("created_at");
				HistoriesBean bean = new HistoriesBean(0,users_id,point);
				bean.setCreatedAt(created_at);
			
				list.add(bean);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("レコードの取得に失敗しました");
		 } finally {
			try {
				if (rs != null) {
						rs.close();
				}
					
				if (st != null) {
						st.close();
				}
				close();
			} catch (Exception e) {
				e.printStackTrace();
//				throw new DAOException("リソースの開放に失敗しました");
			}
		}
	}

}
