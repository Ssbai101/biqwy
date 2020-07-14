package com.biqwy.entity;

public class BIQWY_USER {
	private String id;
	private String name;
	private String password;
	private String sex;
	private String addr;	
	private String memo;
	private int status;
	public BIQWY_USER(String id, String name, String password, String sex, String addr, String memo, int status) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.sex = sex;
		this.addr = addr;
		this.memo = memo;
		this.status = status;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
}