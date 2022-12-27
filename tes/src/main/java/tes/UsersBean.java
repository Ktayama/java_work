package tes;
import java.sql.Timestamp;

public class UsersBean {
	//privateでUsersBeanっクラスのみアクセス可能
	//int型のidを指定
	private int id;
	//String型のnameを指定
	private String name;
	//Stringのpsswordの値を指定
	private String password;
	//
	private byte admin_flag;
	private Timestamp created_at;
	private Timestamp updated_at;
	
	private byte deleteflag; 
	private Timestamp deleted_at;

/**
 * コンストラクタ
 */
	public UsersBean(int id, String name, String password, byte admin_flag) {
		this.id = id;
		this.name = name;
		this.password = password;
	}
	
	/** 引数無しのコンストラクタ **/
	public UsersBean() {

	}

	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
	} 
	
	public String getName() {
		return this.name;
	}	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getPassword() {
		return this.password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public byte getAdminflag() {
		return this.admin_flag;
	}
	public void setAdminflag(byte admin_flag) {
		this.admin_flag = admin_flag;
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
	
	public byte getDeleteflag() {
		return this.deleteflag;
	}
	public void setDeleteflag(byte delete_flag) {
		this.deleteflag = delete_flag;
	}


}
