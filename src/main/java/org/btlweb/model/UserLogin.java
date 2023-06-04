package org.btlweb.model;

public class UserLogin {
    private int id;
    private int userID;
    private String fullName;
    private String username;
    private String password;
    private String role;
    private String image;
  
    private String email;
    
    public UserLogin() {
    }
    
    public UserLogin(int id, int userID, String fullName, String username, String password, String role, String image,String email) {
        this.id = id;
        this.userID = userID;
        this.fullName = fullName;
        this.username = username;
        this.password = password;
        this.role = role;
        this.image = image;
       
        this.email = email;
    }
    
    // Getters and Setters
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public int getUserID() {
        return userID;
    }
    
    public void setUserID(int userID) {
        this.userID = userID;
    }
    
    public String getfullName() {
        return fullName;
    }
    
    public void setfullName(String fullName) {
        this.fullName = fullName;
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
    
    public String getRole() {
        return role;
    }
    
    public void setRole(String role) {
        this.role = role;
    }
    
    public String getimage() {
        return image;
    }
    
    public void setimage(String image) {
        this.image = image;
    }
    
    
    public String getemail() {
		return email;
	}
	
	public void setemail(String email) {
		this.email = email;
	}
}
