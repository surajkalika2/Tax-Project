package com.learning.j10.model;

public class LoginCredentials {
	private String userName;
	private String password;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "LoginCredentials [userName=" + userName + ", password=" + password + "]";
	}
	public LoginCredentials(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}
	public LoginCredentials() {
	}
}
