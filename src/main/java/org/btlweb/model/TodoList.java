package org.btlweb.model;

import java.sql.Date;

public class TodoList {
	private int id;
	private int userID;
	private String todoName;
	private Date createAt;
	private Date endAt;
	private String note;
	private String status;
	
	public TodoList(int id, int userID,Date createAt,Date endAt ,String todoName, String note, String status) {
		this.userID = userID;
		this.todoName = todoName;
		this.note = note;
		this.id = id;
		this.status = status;
		this.createAt = createAt;
		this.endAt = endAt;
	}
	
	public int getID() {
		return id;
	}
	
	public void setID(int id) {
		this.id = id;
	}
	
	public String getTodoName() {
		return todoName;
	}
	
	public void setTodoName(String todoName) {
		this.todoName = todoName;
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
	
	public int getUserID() {
		return userID;
	}
	
	public void setUserID(int userID) {
		this.userID = userID;
	}

	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

	public Date getEndAt() {
		return endAt;
	}

	public void setEndAt(Date endAt) {
		this.endAt = endAt;
	}
}
