package org.btlweb.dao;

import java.util.List;
import java.util.ArrayList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.btlweb.jdbc.JDBCUnit;
import org.btlweb.model.EditTodoList;

public class ActionTodoListDAO {
	Connection c = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	public void clearAllTodoList() {
		String query = "Delete from [BTLWEB].[dbo].[TodoList]";
		try {
			c = new JDBCUnit().getConnection();
			ps = c.prepareStatement(query);
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public void doneAllTodoList() {
		String query = "Update [BTLWEB].[dbo].[TodoList] set status = 'Done'";
		try {
			c = new JDBCUnit().getConnection();
			ps = c.prepareStatement(query);
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public void clearFinishedTodoList() {
		String query = "Delete from [BTLWEB].[dbo].[TodoList] where status = 'Done'";
		try {
			c = new JDBCUnit().getConnection();
			ps = c.prepareStatement(query);
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public void clearInProcessTodoList() {
		String query = "Delete from [BTLWEB].[dbo].[TodoList] where status = 'In Process'";
		try {
			c = new JDBCUnit().getConnection();
			ps = c.prepareStatement(query);
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
