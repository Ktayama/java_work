package tes;

import java.sql.Timestamp;
public class Correct_answersBean {
	private int id;
	private int question_id;
	private String answer;
	private Timestamp created_at;
	private Timestamp updated_at;
	/**
	 * コンストラクタ
	 */
		public Correct_answersBean(int id, int question_id , String answer) {
			this.id = id;
			this.question_id = question_id;
			this.answer = answer;
		}
		/** 引数無しのコンストラクタ **/
		public Correct_answersBean() {

		}
	    //getIdでidを定義している
		public int getId() {
			return this.id;
		}
		//setidは７行目で定義した変数idに格納している
		public void setId(int id) {
			this.id = id;
		} 
		public int getQuestion_id() {
			return this.question_id;
		}	
		public void setQuestion_id(int Questiion_id) {
			this.question_id = Questiion_id;
		}
		public String getAnswer() {
			return this.answer;
		}
		public void setAnswer(String Answer) {
			this.answer = Answer;
		}
		
		public Timestamp getCreatedAt() {
			return this.created_at;
		}
		public void setCreatedAt(Timestamp created_at) {
			this.created_at = created_at;
		}
		public Timestamp getUpdatedAt() {
			return this.updated_at;
		}
		public void setUpdatedAt(Timestamp updated_at) {
			this.updated_at = updated_at;
		}
}
