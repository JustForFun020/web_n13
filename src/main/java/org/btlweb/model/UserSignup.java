package org.btlweb.model;

public class UserSignup {
	private int id;
	private String fulllname;
	private String username;
	private String email;
	private String password;
	
	public UserSignup(String fullname,String username, String password, String email) {
		this.fulllname = fullname;
		this.username = username;
		this.password = password;
		this.email = email;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
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
