package org.btlweb.model;

import java.util.Date;

public class Report {
	private String userName;
	private int totalFocus;
	private String image;
	
	public Report(String userName,int totalFocus,String image) {
		this.totalFocus = totalFocus;
		this.userName = userName;
		this.image = image;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getTotalFocus() {
		return totalFocus;
	}

	public void setTotalFocus(int totalFocus) {
		this.totalFocus = totalFocus;
	}
	
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
}
