package org.btlweb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;

import org.btlweb.jdbc.JDBCUnit;
import org.btlweb.model.AddTodoList;

public class AddTodoListDAO {
	Connection c = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	private static final int User_ID = 1;
	
	public AddTodoList addTodoList(String todoName, int endAt, String note, String status) {
		AddTodoList listTodo = null;
		String query = "INSERT INTO [BTLWEB].[dbo].[TodoList] (userID, todoName, createAt, endAt, note, status) VALUES (?, ?, ?, ?, ?, ?)";
		try {
			c = new JDBCUnit().getConnection();
			ps = c.prepareStatement(query);
			ps.setInt(1, User_ID);
			ps.setString(2, todoName);
			ps.setTimestamp(3, getCurrentTimestamp());
			ps.setTimestamp(4,getTimestampAfterMinutes(endAt));
			ps.setString(5, note);
			ps.setString(6, status);
			ps.executeUpdate();
			
			listTodo = new AddTodoList(todoName, endAt, note);
			listTodo.setUserID(User_ID);
			listTodo.setStatus("In Process");
			listTodo.setCreateAt(getCurrentTimestamp());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return listTodo;
	}
	
    private Timestamp getCurrentTimestamp() {
        return new Timestamp(System.currentTimeMillis());
    }

    private Timestamp getTimestampAfterMinutes(int minutes) {
        long milliseconds = System.currentTimeMillis() + minutes * 60 * 1000;
        return new Timestamp(milliseconds);
    }
}
