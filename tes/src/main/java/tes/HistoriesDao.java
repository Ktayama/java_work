package tes;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
			String sql = "INSERT INTO histories ( user_id, point, created_at, ) values (?,?,current_timestamp());";
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

}
