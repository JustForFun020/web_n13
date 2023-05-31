package org.btlweb.controller;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.btlweb.model.UserLogin;

import org.btlweb.dao.*;

import org.btlweb.jdbc.JDBCUnit;

@WebServlet(urlPatterns = "/admin/user/delete") // ?uid=1
public class DeleteUserController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    String userId = req.getParameter("userID");
	    UserDAO userDao = new UserDAOIMPL();
	    userDao.delete(Integer.parseInt(userId));
	    resp.sendRedirect(req.getContextPath() + "/admin/user/search");
	}

}