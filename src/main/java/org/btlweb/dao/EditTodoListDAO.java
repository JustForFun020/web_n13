package org.btlweb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.btlweb.jdbc.JDBCUnit;
import org.btlweb.model.EditTodoList;

public class EditTodoListDAO {
	Connection c = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	public void updateTask(int id, String todoName, int endAt, String note) {
		String query = "Update [BTLWEB].[dbo].[TodoList] set todoName = ?, endAt = DATEADD(minute, ?, GETDATE()), note = ? where id = ?";
		try {
			c = new JDBCUnit().getConnection();
			ps = c.prepareStatement(query);
			ps.setString(1, todoName);
			ps.setInt(2, endAt);
			ps.setString(3, note);
			ps.setInt(4, id);
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public void deleteTask(int id) {
		String query = "Delete from [BTLWEB].[dbo].[TodoList] where id = ?";
		try {
			c = new JDBCUnit().getConnection();
			ps = c.prepareStatement(query);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void changeStatusDone(int id) {
		String query = "Update [BTLWEB].[dbo].[TodoList] set status = 'Done' where id = ?";
		try {
			c = new JDBCUnit().getConnection();
			ps = c.prepareStatement(query);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public void changeStatusInProcess(int id) {
		String query = "Update [BTLWEB].[dbo].[TodoList] set status = 'In Process' where id = ?";
		try {
			c = new JDBCUnit().getConnection();
			ps = c.prepareStatement(query);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
