package db_vo;

public class Transfer {
	private String a_id_out;
	private String a_id_in;
	private String currency;
	private double amount;
	private String transfer_time;
	private String memo;

	public String getA_id_out() {
		return a_id_out;
	}
	public void setA_id_out(String a_id_out) {
		this.a_id_out = a_id_out;
	}
	public String getA_id_in() {
		return a_id_in;
	}
	public void setA_id_in(String a_id_in) {
		this.a_id_in = a_id_in;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getTransfer_time() {
		return transfer_time;
	}
	public void setTransfer_time(String transfer_time) {
		this.transfer_time = transfer_time;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	

}
