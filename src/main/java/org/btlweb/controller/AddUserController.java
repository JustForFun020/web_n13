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

@WebServlet(urlPatterns = "/admin/user/add")
public class AddUserController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("/jsp/admin/user/addUser.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String idString = req.getParameter("userID");
		int id = Integer.parseInt(idString);
		String name = req.getParameter("fullName");
		String email = req.getParameter("email");
		String username = req.getParameter("username");
		String password = req.getParameter("password");

		String role = req.getParameter("role");
		String image = req.getParameter("image");

		UserLogin user = new UserLogin();
		user.setUserID(id);
		user.setfullName(name);
		user.setemail(email);
		user.setUsername(username);
		user.setPassword(password);
		user.setRole(role);
		user.setimage(image);
		// goi lop service de luu xuong database
		UserDAO userDao = new UserDAOIMPL();
		userDao.add(user);
		// chuyen trang
		resp.sendRedirect("/BTLWEB_N13/admin/user/search");

	}
}