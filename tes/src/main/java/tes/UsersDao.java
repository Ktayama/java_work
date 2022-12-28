package tes;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class UsersDao extends ConnectionDao {

	/**
	 * コンストラクタ
	 */
	public UsersDao() throws Exception {
		setConnection();
	}

	/**
	 * users テーブルを全件取得
	 */
	//public List<UsersBean> findAll() throws DAOException, Exception {
	//	if (con == null) {
	//		setConnection();
	//	}
	//	
	//	PreparedStatement st = null;
	//	ResultSet rs = null;
	//	try {
		//	String sql = "SELECT id, name, password FROM users WHERE delete_flag = 0";
		//	/** PreparedStatement オブジェクトの取得**/
		//	st = con.prepareStatement(sql);
		//	/** SQL 実行 **/
		//	rs = st.executeQuery();
		//	/** select文の結果をArrayListに格納 **/
		//	List<UsersBean> list = new ArrayList<UsersBean>();
		//	while (rs.next()) {
		//	int id = rs.getInt("id");
		//		String name = rs.getString("name");
		//		String pass = rs.getString("password");
		//		UsersBean bean = new UsersBean(id, name, pass);
		//		list.add(bean);
		//	}
	//		return list;
	//	} catch (Exception e) {
	//		e.printStackTrace();
	//		throw new DAOException("レコードの取得に失敗しました");
	//	} finally {
	//		try {
	//			if (rs != null) {
	//					rs.close();
	//			}
	//				
	//			if (st != null) {
	//					st.close();
	//			}
	//			close();
	//		} catch (Exception e) {
	//			e.printStackTrace();
//				throw new DAOException("リソースの開放に失敗しました");

			//}
		//}
	//}

	/**
	 * users テーブルからidの取得を一致させる
	
	 * 指定IDのレコードを取得する
	 */
	//UsersBeanのオブジェクトを返却
	//
	public UsersBean find(int user_id) throws DAOException, Exception {
		//データベースに接続されているかの判定
		if (con == null) {
			//データベースに接続される
			setConnection();
		}
		//sql実行前の準備
		PreparedStatement st = null;
		//sql実行結果の格納用
		ResultSet rs = null;
		try {
			//usersテーブルから指定idを持つレコードの取得
			String sql = "SELECT id,name, password,admin_flag, delete_flag FROM users WHERE delete_flag =0 and id = ?";
			
			/** PreparedStatement オブジェクトの取得**/
			st = con.prepareStatement(sql);
			//一つ目の「？」をuser_idに置換
			st.setInt(1, user_id);
			//sqlを実行し結果をrsに格納
			rs = st.executeQuery();
			//UsersBean型のオブジェクト、「bean」変数を用意
			UsersBean bean = new UsersBean();
			//next()メソッドで最初の行に移動する
			//sqlの実行結果を先頭から1行ずつ順にループする
			while (rs.next()) {
				//sqlの実行結果を各変数に格納
				//データベースで登録をしたid,name,passの一件目に移動する
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String pass = rs.getString("password");
				byte admin_flag = rs.getByte("admin_flag");
				//UsersBeanの箱にId,Name,Passwordセットさせている
				bean.setId(id);
				bean.setName(name);
				bean.setPassword(pass);
				bean.setAdminflag(admin_flag);
			}
			//beanを返している
			return bean;
		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("レコードの取得に失敗しました");
		} finally {
			try {
				//sqlの実行結果をclose
				if (rs != null){
						rs.close();
				}				
				if (st != null) {
						st.close();
				}//ConnectionDaoのcloseを呼び出している
				close();
				} catch (Exception e)
			{
				e.printStackTrace();
				throw new DAOException("リソースの開放に失敗しました");
			}
		}
	}
	
	public void DeleteserUpdata(int id) throws DAOException, Exception {
		//データベースに接続されているかの判定
		if (con == null) {
			//データベースに接続される
			setConnection();
		}
		//sql実行前の準備
		PreparedStatement st = null;
		//sql実行結果の格納用
		ResultSet rs = null;
		try {
			String sql = "update users set delete_flag = 1, deleted_at = current_timestamp() where id = ?";
			
			st = con.prepareStatement(sql);
		
			st.setInt(1, id);
			/** SQL 実行 **/
			st.executeUpdate();
			return ;
		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("レコードの取得に失敗しました");
		} finally {
			try {
				//sqlの実行結果をclose
				if (rs != null){
						rs.close();
				}				
				if (st != null) {
						st.close();
				}//ConnectionDaoのcloseを呼び出している
				close();
				} catch (Exception e)
			{
				e.printStackTrace();
				throw new DAOException("リソースの開放に失敗しました");
			}
		}
	}
	
	public void Insert(String pass,String name, byte adminFlag) throws DAOException, Exception {
		//データベースに接続されているかの判定
		if (con == null) {
			//データベースに接続される
			setConnection();
		}
		//sql実行前の準備
		PreparedStatement st = null;
		//sql実行結果の格納用
		ResultSet rs = null;
		try {
			String sql = "Insert INTO users (password,name,admin_flag,delete_flag,created_at)values(?,?,?,0,current_timestamp());";
			
			st = con.prepareStatement(sql);
		
			st.setString(1, pass);
			st.setString(2, name);
			st.setByte(3, adminFlag);
			/** SQL 実行 **/
			st.executeUpdate();
			return ;
		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("レコードの取得に失敗しました");
		} finally {
			try {
				//sqlの実行結果をclose
				if (rs != null){
						rs.close();
				}
				if (st != null) {
						st.close();
				}//ConnectionDaoのcloseを呼び出している
				close();
				} catch (Exception e)
			{
				e.printStackTrace();
				throw new DAOException("リソースの開放に失敗しました");
			}
		}
	}
	
	public void UPDATAD(String pass, byte adminFlag ,int id) throws DAOException, Exception {
		//データベースに接続されているかの判定
		if (con == null) {
			//データベースに接続される
			setConnection();
		}
		//sql実行前の準備
		PreparedStatement st = null;
		//sql実行結果の格納用
		ResultSet rs = null;
		try {
			String sql = "update users set password=?,admin_flag=?  where id=?";
			
			st = con.prepareStatement(sql);
		
			st.setString(1, pass);
			st.setByte(2, adminFlag);
			st.setInt(3, id);
			/** SQL 実行 **/
			st.executeUpdate();
			return ;
		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("レコードの取得に失敗しました");
		} finally {
			try {
				//sqlの実行結果をclose
				if (rs != null){
						rs.close();
				}				
				if (st != null) {
						st.close();
				}//ConnectionDaoのcloseを呼び出している
				close();
				} catch (Exception e)
			{
				e.printStackTrace();
				throw new DAOException("リソースの開放に失敗しました");
			}
		}
	}
	
	public ArrayList<UsersBean> findAll() throws DAOException, Exception {
		//データベースに接続されているかの判定
		if (con == null) {
			//データベースに接続される
			setConnection();
		}
		//sql実行前の準備
		PreparedStatement st = null;
		//sql実行結果の格納用
		ResultSet rs = null;
		try {
			//usersテーブルから指定idを持つレコードの取得
			String sql = "SELECT id, name, password,admin_flag FROM users WHERE delete_flag = 0";
			/** PreparedStatement オブジェクトの取得**/
			st = con.prepareStatement(sql);
			rs = st.executeQuery();
			
			ArrayList<UsersBean> list = new ArrayList<UsersBean>();
			//next()メソッドで最初の行に移動する
			//sqlの実行結果を先頭から1行ずつ順にループする
			while (rs.next()) {
				//sqlの実行結果を各変数に格納
				//データベースで登録をしたid,name,passの一件目に移動する
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String pass = rs.getString("password");
				byte admin_flag = rs.getByte("admin_flag");
				//UsersBeanの箱にId,Name,Passwordセットさせている
				
				UsersBean bean = new UsersBean(id,name,pass,admin_flag);
				
				list.add(bean);
			}
			//listを返してい
			return list;
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("レコードの取得に失敗しました");
		} finally {
			try {
				//sqlの実行結果をclose
				if (rs != null){
						rs.close();
				}				
				if (st != null) {
						st.close();
				}//ConnectionDaoのcloseを呼び出している
				close();
				} catch (Exception e)
			{
				e.printStackTrace();
				throw new DAOException("リソースの開放に失敗しました");
			}
		}
	}
}
