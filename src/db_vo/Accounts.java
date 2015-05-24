package db_vo;

public class Accounts {
	private String a_id;
	private String u_id;
	private String bind_date;
	private String trans_pwd;

	public String getBind_date() {
		return bind_date;
	}
	public String getA_id() {
		return a_id;
	}
	public void setA_id(String a_id) {
		this.a_id = a_id;
	}
	public String getU_id() {
		return u_id;
	}
	public void setU_id(String u_id) {
		this.u_id = u_id;
	}
	public void setBind_date(String bind_date) {
		this.bind_date = bind_date;
	}
	public String getTrans_pwd() {
		return trans_pwd;
	}
	public void setTrans_pwd(String trans_pwd) {
		this.trans_pwd = trans_pwd;
	}
	

}
