package com.model;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String firstName;
	private String lastName;
	private String email;
	private Login login;
	private Date createdDate;
	private Date upatedDate;
	
	public User() {}
	
	public User(Integer id, String firstName, String lastName, String email, Login login,
			Date createdDate, Date upatedDate) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.login = login;
		this.createdDate = createdDate;
		this.upatedDate = upatedDate;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Login getLogin() {
		return login;
	}
	public void setLogin(Login login) {
		this.login = login;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public Date getUpatedDate() {
		return upatedDate;
	}
	public void setUpatedDate(Date upatedDate) {
		this.upatedDate = upatedDate;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", email=" + email + ", login=" + login + ", createdDate=" + createdDate + ", upatedDate="
				+ upatedDate + "]";
	}
}
