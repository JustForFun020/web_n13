package org.btlweb.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.btlweb.dao.ActionTodoListDAO;

@ WebServlet( urlPatterns ="/action-task")
public class ActionTodoListController extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ActionTodoListController() {
		super();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = req.getParameter("action");
		ActionTodoListDAO actionTodoListDAO = new ActionTodoListDAO();
		
		if(action != null) {
			 switch (action) {
			 	case "done-all-task": 
			 		actionTodoListDAO.doneAllTodoList();
			 		resp.sendRedirect(req.getContextPath() + "/jsp/index.jsp");
			 		break;
			 	case "clear-all-task":
			 		actionTodoListDAO.clearAllTodoList();
			 		resp.sendRedirect(req.getContextPath() + "/jsp/index.jsp");
			 		break;
			 	case "clear-finished-task":
			 		actionTodoListDAO.clearFinishedTodoList();
			 		resp.sendRedirect(req.getContextPath() + "/jsp/index.jsp");
			 		break;
			 	case "clear-inprocess-task":
			 		actionTodoListDAO.clearInProcessTodoList();
			 		resp.sendRedirect(req.getContextPath() + "/jsp/index.jsp");
			 		break;
			 	default:
			 		throw new IllegalArgumentException("Unexpected value: " + action);
			}
		}
	}
}
