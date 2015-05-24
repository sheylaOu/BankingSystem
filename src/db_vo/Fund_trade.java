package db_vo;

public class Fund_trade {
	private int f_id;
	private String a_id;
	private String type;
	private double net_unit;
	private double money;
	private String trade_time;
	public int getF_id() {
		return f_id;
	}
	public void setF_id(int f_id) {
		this.f_id = f_id;
	}

	public String getA_id() {
		return a_id;
	}
	public void setA_id(String a_id) {
		this.a_id = a_id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public double getNet_unit() {
		return net_unit;
	}
	public void setNet_unit(double net_unit) {
		this.net_unit = net_unit;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	public String getTrade_time() {
		return trade_time;
	}
	public void setTrade_time(String trade_time) {
		this.trade_time = trade_time;
	}
	
}
