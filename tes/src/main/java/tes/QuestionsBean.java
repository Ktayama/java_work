package tes;
import java.sql.Timestamp;

public class QuestionsBean {
	private int id;
	private String question;
	private Timestamp created_at;
	private Timestamp updated_at;

	public QuestionsBean(int id, String question) {
		this.id = id;
		this.question =question ;
	}
	
	/** 引数無しのコンストラクタ **/
	public QuestionsBean() {

	}
    
	public int getId() {
		return this.id;
	}
	//setidは７行目で定義した変数idに格納している
	public void setId(int id) {
		this.id = id;
	} 
	public String getQuestion() {
		return this.question;
	}	
	public void setQuestion(String Questiion) {
		this.question = Questiion;
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
