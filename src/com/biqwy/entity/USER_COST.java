package com.biqwy.entity;

public class USER_COST {
	private String cost_id;
	private String cost_name;
	private String cost_water;
	private String cost_electric;
	private String cost_clean;
	public USER_COST(String cost_id, String cost_name, String cost_water, String cost_electric, String cost_clean) {
		super();
		this.cost_id = cost_id;
		this.cost_name = cost_name;
		this.cost_water = cost_water;
		this.cost_electric = cost_electric;
		this.cost_clean = cost_clean;
	}
	public String getCost_id() {
		return cost_id;
	}
	public void setCost_id(String cost_id) {
		this.cost_id = cost_id;
	}
	public String getCost_name() {
		return cost_name;
	}
	public void setCost_name(String cost_name) {
		this.cost_name = cost_name;
	}
	public String getCost_water() {
		return cost_water;
	}
	public void setCost_water(String cost_water) {
		this.cost_water = cost_water;
	}
	public String getCost_electric() {
		return cost_electric;
	}
	public void setCost_electric(String cost_electric) {
		this.cost_electric = cost_electric;
	}
	public String getCost_clean() {
		return cost_clean;
	}
	public void setCost_clean(String cost_clean) {
		this.cost_clean = cost_clean;
	}
	
	
}