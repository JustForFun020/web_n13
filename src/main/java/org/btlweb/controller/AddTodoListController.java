package org.btlweb.controller;

import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.annotation.WebServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.btlweb.dao.AddTodoListDAO;
import org.btlweb.jdbc.JDBCUnit;

@WebServlet( urlPatterns = "/addtodolist")
public class AddTodoListController extends HttpServlet  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AddTodoListController() {
		super();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String todoName = req.getParameter("todoName");
		int endAt = Integer.parseInt(req.getParameter("endAt"));
		String note = req.getParameter("note");
		String status = "In Process";
		AddTodoListDAO addTodoList = new AddTodoListDAO();
		addTodoList.addTodoList(todoName, endAt, note, status);
		resp.sendRedirect(req.getContextPath() + "/jsp/index.jsp");
	}
}