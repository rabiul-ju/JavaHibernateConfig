package com.model;

import java.io.Serializable;

public class Login implements Serializable{
	
	private static final long serialVersionUID = 1L;
	public Login () {}
	public Login(Integer id, String mobileNumber, String password) {
		super();
		this.id = id;
		this.mobileNumber = mobileNumber;
		this.password = password;
	}
	private Integer id;
	private String mobileNumber;
	private String password;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Login [id=" + id + ", mobileNumber=" + mobileNumber + ", password=" + password + "]";
	}
	
}
