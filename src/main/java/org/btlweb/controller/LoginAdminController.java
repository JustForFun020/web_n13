package org.btlweb.controller;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.btlweb.dao.UserSignupDAO;
import org.btlweb.model.UserLogin;

import org.btlweb.dao.*;

import org.btlweb.jdbc.JDBCUnit;

@WebServlet(urlPatterns = "/login-admin") // ?errCode=100
public class LoginAdminController extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String code = req.getParameter("errCode");

		if (code != null && code.equals("100")) {
			req.setAttribute("msg1", "Tai khoan hoac mat khau sai");
		}
		RequestDispatcher dispathcer = req.getRequestDispatcher("/jsp/admin/Login.jsp");
		dispathcer.forward(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String pass = req.getParameter("password");

		UserDAO userDao = new UserDAOIMPL();
		UserLogin user = userDao.getByUsername(username);

		if (user != null && user.getPassword().equals(pass) && user.getRole().equals("admin")) {
			System.out.println("Log in success");

			resp.sendRedirect(req.getContextPath() + "/admin/user/list"); // respond : server tra ve
		} else {
			System.out.println("Fail");
			resp.sendRedirect(req.getContextPath() + "/login-admin?errCode=100");
		}
	}
}