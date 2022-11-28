package tes;

import java.sql.Timestamp;
public class HistoriesBean {
	private int id;
	private int userid;
	private int point;
	private Timestamp created_at;
	/**
	 * コンストラクタ
	 */
	public HistoriesBean(int id, int userid , int point) {
		this.id = id;
		this.userid = userid;
		this.point = point;
	}
	/** 引数無しのコンストラクタ **/
	public HistoriesBean() {
	}
    //getIdでidを定義している
	public int getId() {
		return this.id;
	}
	//setidは７行目で定義した変数idに格納している
	public void setId(int id) {
		this.id = id;
	} 
	public int getUserId() {
		return this.userid;
	}	
	public void setUserId(int UserId) {
		this.userid = UserId;
	}
	public int getPoint() {
		return this.point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	
	public Timestamp getCreatedAt() {
		return this.created_at;
	}
	public void setCreatedAt(Timestamp created_at) {
		this.created_at = created_at;
	}
}
