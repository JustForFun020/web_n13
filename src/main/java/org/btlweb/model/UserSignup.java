package org.btlweb.model;

public class UserSignup {
	private String fulllname;
	private String username;
	private String email;
	private String password;
	
	public UserSignup(String fullname,String username, String email, String password) {
		this.fulllname = fullname;
		this.username = username;
		this.email = email;
		this.password = password;
	}

	public String getFullname() {
		return fulllname;
	}
	
	public void setFullname(String fullname) {
		this.fulllname = fullname;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
}
