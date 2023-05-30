package org.btlweb.controller;

import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.btlweb.dao.TodoListDAO;
import org.btlweb.model.TodoList;

public class TodoListController extends HttpServlet {
	 @Override
	 protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 TodoListDAO todoListDAO = new TodoListDAO();
		List<TodoList> todoList = todoListDAO.getAllTodoList();
		req.setAttribute("todoLists", todoList);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/jsp/_header.jsp");
		dispatcher.forward(req, resp);
	}
}
