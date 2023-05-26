package org.btlweb.model;

public class UserAccounts {
	private int ID;
	private String userName;
	private String password;
	private String role;
	
	public UserAccounts(int ID, String userName, String password, String role) {
		this.ID = ID;
		this.userName = userName;
		this.password = password;
		this.role = role;
	}
	
	public int getID() {
		return ID;
	}
	
	public void setID(int ID) {
		this.ID = ID;
	}
	
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
	
	public String getRole() {
		return role;
	}
	
	public void setRole(String role) {
		this.role = role;
	}
}
