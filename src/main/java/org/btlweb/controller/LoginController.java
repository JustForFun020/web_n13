package org.btlweb.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.btlweb.model.UserAccounts;
import org.btlweb.dao.UserDAO;
import org.btlweb.jdbc.JDBCUnit;

public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public LoginController() {
		super();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String account = req.getParameter("taikhoan");
		String password = req.getParameter("matkhau");
		String errAccount = req.getParameter("loi__taikhaon");
		UserDAO userDAO = new UserDAO();
		UserAccounts user = userDAO.findUser(account, password);
		if(user != null) {
			resp.sendRedirect(req.getContextPath() + "/jsp/index.jsp");
		}
		else {
			req.setAttribute("errLogin", "Tài khoản hoặc mật khẩu không đúng!");
	        RequestDispatcher dispatcher = req.getRequestDispatcher(req.getContextPath() + "/login.jsp");
	        dispatcher.forward(req, resp);
		}
	}
}
