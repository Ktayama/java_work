package tes;

//import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class RegisterDao extends ConnectionDao{

	//インスタンスオブジェクトを返却してコード簡略化
	public  RegisterDao () throws Exception {
		setConnection();
	}
	
	
	public RegisterBean InsertRegister(RegisterBean input_register) throws DAOException,Exception {
		//ConnectionDaoにてデータベースの接続
		if (con == null) {
			setConnection();
		}
		String question = input_register.getQuestions_text();
		String answer = input_register.getAnswer_text();
		

		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			//実行するsql文をセット(空文字)
			String sql = "INSERT INTO question (question)VALUES(?) ";
			sql="INSERT INTO correct_answers(answer)VALUES(?) ";
			
			//DBで実行するsql文を「prepareStatement」インスタンスに格納する
			//PreparedStatement ps = con.prepareStatement(sql);
			
			//登録するquestionとanswerをセットする
			st.setString(1, question);
			st.setString(2, answer);
			
			//SQL実行
			st.executeUpdate();
			
			return input_register;
			
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
			throw new DAOException("リソースの開放に失敗しました");

			}
		}
		
		
	}
}
