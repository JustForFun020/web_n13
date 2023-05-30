package org.btlweb.model;

import java.util.Date;

public class AddTodoList {
	private int id;
	private String todoName;
	private int userID;
	private Date createAt;
	private int endAt;
	private String note;
	private String status;
	
	public AddTodoList(String todoName, int endAt, String note) {
		this.todoName = todoName;
		this.userID = userID;
		this.endAt = endAt;
		this.note = note;
		this.status = status;
	}
	
	public int getUserID() {
		return userID;
	}
	
	public void setUserID(int userID) {
		this.userID = userID;
	}
	
	public String getTodoName() {
		return todoName;
	}
	
	public void setTodoName(String todoName) {
		this.todoName = todoName;
	}
	
	public Date getCreateAt() {
		return createAt;
	}
	
	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}
	
	public int getEndAt() {
		return endAt;
	}
	
	public void setEndAt(int endAt) {
		this.endAt = endAt;
	}
	
	public String getNote() {
		return note;
	}
	
	public void setNote(String note) {
		this.note = note;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
}
