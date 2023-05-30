package org.btlweb.model;

import java.sql.Date;

public class TodoList {
	private int id;
	private String userID;
	private String todoName;
	private Date createAt;
	private Date endAt;
	private String note;
	private String status;
	
	public TodoList(int id ,String todoName, String note, String status) {
		this.todoName = todoName;
		this.note = note;
		this.id = id;
		this.status = status;
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
}
