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
				todoLists.add(new TodoList(rs.getInt(1),rs.getInt(2) ,rs.getString(3), rs.getString(6), rs.getString(7)));
			}
			System.out.println(todoLists);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return todoLists;
	}
	 public static void main(String[] args) {
		TodoListDAO dao = new TodoListDAO();
		List<TodoList> a = dao.getAllTodoList(2);
		for(TodoList a1 : a) {
			System.out.println(a1.getTodoName());
		}
	}
}
