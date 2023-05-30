package org.btlweb.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.btlweb.dao.EditTodoListDAO;

@WebServlet( urlPatterns = "/edit-task")
public class EditTodoListController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = req.getParameter("edit-action");
		EditTodoListDAO editTodoListDAO = new EditTodoListDAO();
		int todoID = Integer.parseInt(req.getParameter("chinhsua__todo__id"));
		String endAtStr = req.getParameter("chinhsua__endAt");
		int endAt;
		
		if(action != null) {
			switch (action) {
				case "edit-update-task": 
					if (endAtStr != null && !endAtStr.isEmpty()) {
					    endAt = Integer.parseInt(endAtStr);
					    String todoName = req.getParameter("chinhsua__todoName");
						String note = req.getParameter("chinhsua__note");
						editTodoListDAO.updateTask(todoID, todoName, endAt, note);
					} else {
					    endAt = 25;
					    String todoName = req.getParameter("chinhsua__todoName");
						String note = req.getParameter("chinhsua__note");
						editTodoListDAO.updateTask(todoID, todoName, endAt, note);
					}
					resp.sendRedirect(req.getContextPath() + "/jsp/index.jsp");
					break;
				case "edit-delete-task":
					 editTodoListDAO.deleteTask(todoID);
					 resp.sendRedirect(req.getContextPath() + "/jsp/index.jsp");
					break;
				case "change-done-status":
					 editTodoListDAO.changeStatusDone(todoID);
					 resp.sendRedirect(req.getContextPath() + "/jsp/index.jsp");
					break;
				case "change-inprocess-status":
					 editTodoListDAO.changeStatusInProcess(todoID);
					 resp.sendRedirect(req.getContextPath() + "/jsp/index.jsp");
					break;
			default:
				throw new IllegalArgumentException("Unexpected value: " + action);
			}
		}
	}
}
