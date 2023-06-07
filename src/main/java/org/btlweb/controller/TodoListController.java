package org.btlweb.controller;

import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.btlweb.dao.TodoListDAO;
import org.btlweb.model.TodoList;

@ WebServlet( urlPatterns ="/hilo")
public class TodoListController extends HttpServlet {
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	 protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int userID = (int)req.getSession().getAttribute("UserID");
	    TodoListDAO todoListDAO = new TodoListDAO();
	    int total = todoListDAO.countAllTodoList(userID);
	    int done = todoListDAO.countDoneTodoList(userID);
	    int process = todoListDAO.countInProcessTodoList(userID);
	    String jsonResult = "{\"total\":" + total + ", \"done\":" + done + ", \"process\":" + process + "}";
	    resp.setContentType("application/json");
	    resp.setCharacterEncoding("UTF-8");
	    resp.getWriter().write(jsonResult);
	}
}
