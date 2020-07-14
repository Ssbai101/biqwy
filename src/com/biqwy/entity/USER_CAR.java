package com.biqwy.entity;

public class USER_CAR {
	private String car_id;
	private String car_name;
	private String car_number;
	private int car_status;
	public USER_CAR(String car_id, String car_name, String car_number, int car_status) {
		super();
		this.car_id = car_id;
		this.car_name = car_name;
		this.car_number = car_number;
		this.car_status = car_status;
	}
	public String getCar_id() {
		return car_id;
	}
	public void setCar_id(String car_id) {
		this.car_id = car_id;
	}
	public String getCar_name() {
		return car_name;
	}
	public void setCar_name(String car_name) {
		this.car_name = car_name;
	}
	public String getCar_number() {
		return car_number;
	}
	public void setCar_number(String car_number) {
		this.car_number = car_number;
	}
	public int getCar_status() {
		return car_status;
	}
	public void setCar_status(int car_status) {
		this.car_status = car_status;
	}
	
}