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


@WebServlet(urlPatterns = "/login-member") // ?errCode=100
public class LoginUserController extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String code = req.getParameter("errCode");
		if (code != null && code.equals("100")) {
			req.setAttribute("msg1", "Tài khoản hoặc mật khẩu sai");
		}
		if (code != null && code.equals("400")) {
			req.setAttribute("msg1", "Tài khoản đã đăng nhập nhiều lần. Bạn có thể vào database, reset giá trị login counter về 0");
		}
		RequestDispatcher dispathcer = req.getRequestDispatcher("/jsp/login.jsp");
		dispathcer.forward(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String pass = req.getParameter("password");

		UserDAO userDao = new UserDAOIMPL();
		UserLogin user = userDao.getByUsername(username);

		if (user != null && user.getPassword().equals(pass) && user.getRole().equals("user")) {
			int userID = user.getUserID();
			int streak = userDao.dayLogin(userID);
			int hourFocus = userDao.hourFocus(userID);
			req.getSession().setAttribute("streak", streak);
			req.getSession().setAttribute("hourFocus", hourFocus);
			req.getSession().setAttribute("UserID", userID);
			resp.sendRedirect(req.getContextPath() + "/jsp/user/index.jsp");		
		} else {
			resp.sendRedirect(req.getContextPath() + "/login-member?errCode=100");
		}
	}
}