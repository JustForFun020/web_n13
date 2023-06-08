package org.btlweb.dao;

import java.util.List;
import java.util.ArrayList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.btlweb.model.TodoList;
import org.btlweb.jdbc.JDBCUnit;

public class TodoListDAO {
	Connection c = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	public List<TodoList> getAllTodoList(int userID) {
		List<TodoList> todoLists = new ArrayList<>();
		String query = "select * from [BTLWEB].[dbo].[TodoList] t inner join [BTLWEB].[dbo].[Users] u on t.userID = u.id where t.userID = ?";
		try {
			c = new JDBCUnit().getConnection();
			ps = c.prepareStatement(query);
			ps.setInt(1, userID);
			rs = ps.executeQuery();
			while(rs.next()) {
				todoLists.add(new TodoList(rs.getInt(1),rs.getInt(2),rs.getDate(4), rs.getDate(5) ,rs.getString(3), rs.getString(6), rs.getString(7)));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return todoLists;
	}
	
	public int countAllTodoList(int userID) {
		int count = 0;
		String query = "select count(*) from [BTLWEB].[dbo].[TodoList] t where t.userID = ?";
		try {
			c = new JDBCUnit().getConnection();
			ps = c.prepareStatement(query);
			ps.setInt(1, userID);
			rs = ps.executeQuery();
			if(rs.next()) {
				count = rs.getInt(1);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return count;
	}
	public int countDoneTodoList(int userID) {
		int count = 0;
		String query = "select count(*) from [BTLWEB].[dbo].[TodoList] t where t.userID = ? and t.status = 'Done'";
		try {
			c = new JDBCUnit().getConnection();
			ps = c.prepareStatement(query);
			ps.setInt(1, userID);
			rs = ps.executeQuery();
			if(rs.next()) {
				count = rs.getInt(1);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return count;
	}
	public int countInProcessTodoList(int userID) {
		int count = 0;
		String query = "select count(*) from [BTLWEB].[dbo].[TodoList] t where t.userID = ? and t.status='In Process'";
		try {
			c = new JDBCUnit().getConnection();
			ps = c.prepareStatement(query);
			ps.setInt(1, userID);
			rs = ps.executeQuery();
			if(rs.next()) {
				count = rs.getInt(1);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return count;
	}
}
