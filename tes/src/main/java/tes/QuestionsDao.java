package tes;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class QuestionsDao extends ConnectionDao { 

	/**
	 * コンストラクタ
	 */
	//サーブレットでQuestionDaoのインスタンス化を行った際にConnectionDaoに自動的に接続される
	public QuestionsDao() throws Exception {
		//question
		setConnection();
	}
	public ArrayList<QuestionsBean> findAll() throws DAOException, Exception {
		//確認用
		//接続されるとnullに入ってこないから
		//データベースに接続されているかの判定
		if (con == null) {
			//データベースに接続する
			setConnection();
		}
		//実行前の準備
		PreparedStatement st = null;
		//sql実行結果の格納
		ResultSet rs = null;
		try {
			//questionテーブルからidとquestionを表示させる
			String sql = "SELECT id, question  FROM question";
			/** PreparedStatement オブジェクトの取得**/
			st = con.prepareStatement(sql);
			/** SQL 実行 **/
			//sqlを実行してrsに格納
			rs = st.executeQuery();
			/** select文の結果をArrayListに格納 **/
			//ArrayList<QuestionBean>型の変数「list」を用意
			//
			ArrayList<QuestionsBean> list = new ArrayList<QuestionsBean>();
			//next()メソッドで最初の行に移動している
			//sqlの実行結果を先頭から一行ずつ順にループする
			while (rs.next()) {
			//sqlの実行結果を各変数に格納している
				int id = rs.getInt("id");
				String question = rs.getString("question");
				//id,questionが格納されたQuestionBean型の「Bean」用意
				QuestionsBean bean = new QuestionsBean(id,question);
				//QuestionBean型の配列にbeanを追加する
				list.add(bean);
			}
			//listを返している
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("レコードの取得に失敗しました");
		 } finally {
			try {
				//sqlの実行	結果をcolse
				if (rs != null) {
						rs.close();
				}
				if (st != null) {
						st.close();
				}
				//ConnectionDaoのcloseを呼び出している
				close();
			} catch (Exception e) {
				e.printStackTrace();
			throw new DAOException("リソースの開放に失敗しました");
			}
		}
	}
	//questionテーブルへのINSERT用メソッド
	//引数 問題文
	//戻り値 なし
	public void Insert(String question) throws DAOException, Exception {
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
			String sql = "INSERT INTO question ( question, created_at, updated_at) values (?,current_timestamp(),current_timestamp());";
			/** PreparedStatement オブジェクトの取得**/
			st = con.prepareStatement(sql);
			//入力の中身をセットさせる
			//一つ目の「?」にquestionを置換
			st.setString(1, question);
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
	//question_idの最大値を取る
	//引数 なし
	//
	public int getmax_question_id() throws DAOException, Exception {
		//データベースに接続されているかの判定
		if (con == null) {
			//データベースに接続する
			setConnection();
		}
		//実行前の準備
		PreparedStatement st = null;
		//sql実行結果の格納用
		ResultSet rs = null;
		try {
			//idの最大値を返す
			//as idでid列としてmax(id)を取得している
			String sql = "SELECT max(id) as id from question;";
			//stに/** PreparedStatement オブジェクトの取得**/
			st = con.prepareStatement(sql);
			/** SQL 実行 **/
			//sqlを実行してrsに格納
			rs = st.executeQuery();
			//int型でquestion_idを定義している
			int question_id = 0;
			//next()でメソッドで最初の行に移動している
			//sqlの実行結果を先頭から一行ずつ順にループする
			while (rs.next()) {
			//id列を取得
			 question_id = rs.getInt("id");
			}
			//question_idを返している
			return question_id;
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("レコードの取得に失敗しました");
		 } finally {
			try {
				//sqlの実行結果をcloseしている
				if (rs != null) {
						rs.close();
				}
				//ConnectionDaoのcloseを呼び出している
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
	//questionのbeanの中身が取れている
	public QuestionsBean find(int questions_id) throws DAOException, Exception {
		//データベースに接続されているかの判定
		if (con == null) {
			//データベースに接続された
			setConnection();
		}
		//実行前の準備
		PreparedStatement st = null;
		//sql実行結果の格納用
		ResultSet rs = null;
		try {//引数に置き換える
			//questionテーブルからidを選択している
			String sql = "SELECT * FROM question WHERE id = ?";
			/** PreparedStatement オブジェクトの取得**/
			st = con.prepareStatement(sql);
			//1だったらint型で「？」の文にuser_idの処理が入る
			st.setInt(1, questions_id);
			//sqlを実行してrsに格納
			rs = st.executeQuery();
			//QuestionBean型のbeanでインスタンス化させている
			//edit_itemサーブレットの55行目に呼び出している
			QuestionsBean bean = new QuestionsBean();
			//next()でメソッドで最初の行に移動している
			//sqlの実行結果を先頭から一行ずつ順にループする
			while (rs.next()) {
				//sqlの実行結果を各変数に格納している
				int id = rs.getInt("id");
				String question = rs.getString("question");
				//QuestionBeanの箱にis,questionセットさせている
				bean.setId(id);
				bean.setQuestion(question);
			}
			//beanを返している
			return bean;
		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("レコードの取得に失敗しました");
		} finally {
			try {
				//sqlの実行結果をcloseさせている
				if (rs != null){
						rs.close();
				}
				//ConnectionDaoのcloseを呼び出している
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
	
	public void DELETE(int question_id) throws DAOException, Exception {
		//データベースに接続されているかの判定
		if (con == null) {
			//データベースに接続された
			setConnection();
		}
		//実行前の準備
		PreparedStatement st = null;
		//sql実行結果の格納用
		ResultSet rs = null;
		try {
			//insertでquestionテーブルのquestionの中身を入力できる処理
			//String sql = "INSERT INTO question(question) VALUES(?); "
			//questionテーブルの問題と番号を削除文。またcurrent_timestamp(),current_timestamp())で現在時刻が取れている
			// = "delete from question where = (id, question, created_at, updated_at) values (?,?,current_timestamp(),current_timestamp());";
			String sql = "delete from question where id = ?";
			
			/** PreparedStatement オブジェクトの取得**/
			st = con.prepareStatement(sql);
			//入力の中身をセットさせる
			//一つ目の「？」にquestionを置換
			st.setInt(1, question_id);
			/** SQL 実行 **/
			st.executeUpdate();
			
			return ;
		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("レコードの取得に失敗しました");
		 } finally {
			try {
				//ResultSetをcloseさせている
				if (rs != null) {
						rs.close();
				}
				//ConnectionDaoのcloseを呼び出している
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
	//指定したidのquestionテーブルのquestionの更新
	public void UPDATED(String question, int id) throws DAOException, Exception {
		//データベースに接続されているかの判定
		if (con == null) {
			//データベースに接続された
			setConnection();
		}
		//実行前の準備
		PreparedStatement st = null;
		//sql実行結果の格納用
		ResultSet rs = null;
		try {
			
			//questionテーブルの更新
			String sql = "update question set question=?,updated_at=current_timestamp() where id=?;";
			/** PreparedStatement オブジェクトの取得**/
			st = con.prepareStatement(sql);
			//入力の中身をセットさせる
			//一つ目の「？」にquestionを置換
			st.setString(1, question);
			//二つ目の「？」にidを置換
			st.setInt(2, id);
			/** SQL 実行 **/
			st.executeUpdate();
			
			return ;
		} catch (Exception e) {
 			e.printStackTrace();
			throw new DAOException("レコードの取得に失敗しました");
		 } finally {
			try {
				//ResultSetをcloseさせている
				if (rs != null) {
						rs.close();
				}
				//ConnectionDaoのcloseを呼び出している	
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