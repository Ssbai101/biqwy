package com.biqwy.entity;

public class BIQWY_NEWS {
	private String new_id;
	private String new_name;
	private String new_date;
	private String new_title;
	public BIQWY_NEWS(String new_id, String new_name, String new_date, String new_title) {
		super();
		this.new_id = new_id;
		this.new_name = new_name;
		this.new_date = new_date;
		this.new_title = new_title;
	}
	public String getNew_id() {
		return new_id;
	}
	public void setNew_id(String new_id) {
		this.new_id = new_id;
	}
	public String getNew_name() {
		return new_name;
	}
	public void setNew_name(String new_name) {
		this.new_name = new_name;
	}
	public String getNew_date() {
		return new_date;
	}
	public void setNew_date(String new_date) {
		this.new_date = new_date;
	}
	public String getNew_title() {
		return new_title;
	}
	public void setNew_title(String new_title) {
		this.new_title = new_title;
	} 
}