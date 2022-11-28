package tes;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


public class Correct_answersDao extends ConnectionDao { 

	/**
	 * コンストラクタ
	 */
	public Correct_answersDao() throws Exception {
		setConnection();
	}
	
	public ArrayList<Correct_answersBean> findAll() throws DAOException, Exception {
		if (con == null) {
			setConnection();
		}
		
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			String sql = "SELECT id, question_id, answer  FROM correct_answers";
			/** PreparedStatement オブジェクトの取得**/
			st = con.prepareStatement(sql);
			/** SQL 実行 **/
			rs = st.executeQuery();
			/** select文の結果をArrayListに格納 **/
			ArrayList<Correct_answersBean> list = new ArrayList<Correct_answersBean>();
			while (rs.next()) {
			
				int id = rs.getInt("id");
				int question_id = rs.getInt("question_id");
				String answer= rs.getString("answer");
			
				Correct_answersBean bean = new Correct_answersBean(id,question_id,answer); 
			
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
	//RegisterサーブレットからStringでanswer_textを受け取る形にしてる
		//INSERTの型
	public  void Insert(String answer ,int questions_id) throws DAOException, Exception {
			if (con == null) {
				setConnection();
			}
			
			PreparedStatement st = null;
			ResultSet rs = null;
			try {
				//String sql = "INSERT INTO correct_answers(answer) VALUES(?);";
				//
				String sql = "INSERT INTO correct_answers (question_id, answer, created_at, updated_at) values (?,?,current_timestamp(),current_timestamp());";
				/** PreparedStatement オブジェクトの取得**/
				st = con.prepareStatement(sql);
				/** SQL 実行 **/
				st.setInt(1,questions_id);
				
				st.setString(2, answer);
				st.executeUpdate();
				
				
				return ;
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
//					throw new DAOException("リソースの開放に失敗しました");

				}
			}
		}
	//編集
	public  ArrayList<Correct_answersBean> findByQuestionsId(int questionsId ) throws DAOException, Exception {
		if (con == null) {
			setConnection();
		}
		
		PreparedStatement st = null;
		ResultSet rs = null;
		try {//引数に置き換える
			String sql = "SELECT * FROM correct_answers WHERE question_id = ?";
			/** PreparedStatement オブジェクトの取得**/
			st = con.prepareStatement(sql);
			//1だったらint型で「？」の文にuser_idの処理が入る
			st.setInt(1,questionsId);
			rs = st.executeQuery();
			ArrayList<Correct_answersBean> list = new ArrayList<Correct_answersBean>();
			while (rs.next()) {
			
				int id = rs.getInt("id");
				int question_id = rs.getInt("question_id");
				String answer= rs.getString("answer");
			
				Correct_answersBean bean = new Correct_answersBean(id,question_id,answer); 
			
				list.add(bean);
			}
			return list;
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("レコードの取得に失敗しました");
		} finally {
			try {
				if (rs != null){
						rs.close();
				}				
				if (st != null) {
						st.close();
				}
				close();
			} catch (Exception e) {
				e.printStackTrace();
				throw new DAOException("リソースの開放に失敗しました");
			}
		}
	}
		public  void UPSATED(String answer ,int answer_id) throws DAOException, Exception {
			if (con == null) {
				setConnection();
			}
			
			PreparedStatement st = null;
			ResultSet rs = null;
			try {
				//String sql = "INSERT INTO correct_answers(answer) VALUES(?);";
				String sql = "update correct_answers set answer=?,updated_at=current_timestamp() where id=?;";
				/** PreparedStatement オブジェクトの取得**/
				st = con.prepareStatement(sql);
				/** SQL 実行 **/
				
				st.setString(1, answer);
				st.setInt(2,answer_id);
				
				st.executeUpdate();
				
				//
				
				return ;
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
//					throw new DAOException("リソースの開放に失敗しました");

				}
			}
	}
	
		public  void DELETE(int answer_id) throws DAOException, Exception {
			if (con == null) {
				setConnection();
			}
			
			PreparedStatement st = null;
			ResultSet rs = null;
			try {
				String sql = "delete from correct_answers where id =?; ";
				/** PreparedStatement オブジェクトの取得**/
				st = con.prepareStatement(sql);
				/** SQL 実行 **/
				
				
				st.setInt(1,answer_id);
				
				st.executeUpdate();
				
				//
				
				return ;
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
//					throw new DAOException("リソースの開放に失敗しました");

				}
			}
	}
		
}
