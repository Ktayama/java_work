package tes;

public class RegisterBean {
	
	//フィールド
	private String questions_text;
	private String answer_text;
	
	//questions_textのゲッター/セッターを作成
	public String getQuestions_text() {
		return questions_text;
	}
	public void setQuestions_text(String questions) {
		this.questions_text = questions;
	}
	
	//answer_textのゲッター/セッターを作成
	public String getAnswer_text() {
		return answer_text;
	}
	public void setAnswer_text(String answer) {
		this.answer_text = answer;
	}
	
	
	//コンストラクタ：設定なし
	public RegisterBean() {
	}
}
