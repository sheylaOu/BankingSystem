package db_vo;

public class Fund {
	private int f_id;
	private String name;
	private String type;
	private String founded_date;
	private double total_net_assets;
	private double net_unit;
	private double net_cumulative;
	private int regular_min;
	private int purchase_min;
	private String founded_manager;
	public int getF_id() {
		return f_id;
	}
	public void setF_id(int f_id) {
		this.f_id = f_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getFounded_date() {
		return founded_date;
	}
	public void setFounded_date(String founded_date) {
		this.founded_date = founded_date;
	}
	public double getTotal_net_assets() {
		return total_net_assets;
	}
	public void setTotal_net_assets(double total_net_assets) {
		this.total_net_assets = total_net_assets;
	}
	public double getNet_unit() {
		return net_unit;
	}
	public void setNet_unit(double net_unit) {
		this.net_unit = net_unit;
	}
	public double getNet_cumulative() {
		return net_cumulative;
	}
	public void setNet_cumulative(double net_cumulative) {
		this.net_cumulative = net_cumulative;
	}
	public int getRegular_min() {
		return regular_min;
	}
	public void setRegular_min(int regular_min) {
		this.regular_min = regular_min;
	}
	public int getPurchase_min() {
		return purchase_min;
	}
	public void setPurchase_min(int purchase_min) {
		this.purchase_min = purchase_min;
	}
	public String getFounded_manager() {
		return founded_manager;
	}
	public void setFounded_manager(String founded_manager) {
		this.founded_manager = founded_manager;
	}
	

}
