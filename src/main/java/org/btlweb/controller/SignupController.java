package org.btlweb.controller;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.btlweb.dao.UserSignupDAO;
import org.btlweb.model.UserLogin;

import org.btlweb.dao.*;

import org.btlweb.jdbc.JDBCUnit;


@WebServlet(urlPatterns = "/register")
public class SignupController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String code = req.getParameter("errCode");

		if (code != null && code.equals("100")) {
			req.setAttribute("msg1", "Mật khẩu và xác nhận mật khẩu không khớp");
		}
		if (code != null && code.equals("400")) {
			req.setAttribute("msg1", "Tài khoản đã đăng nhập nhiều lần. Bạn có thể vào database, reset giá trị login counter về 0");
		}


		RequestDispatcher dispatcher = req.getRequestDispatcher("/jsp/signup.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// doc du lieu tu form gui len
		String fullName = req.getParameter("fullname");
		String username = req.getParameter("taikhoan");
		String password = req.getParameter("matkhau");
		String email = req.getParameter("email");
		String confirmPassword = req.getParameter("xacnhanmatkhau");
		if (!password.equals(confirmPassword)) {
	        // Mật khẩu và xác nhận mật khẩu không khớp
			System.out.println("matkhaukhongkhop");
			resp.sendRedirect(req.getContextPath() + "/register?errCode=100");
	    } else {

		UserLogin user = new UserLogin();
		user.setfullName(fullName);
		user.setUsername(username);
		user.setemail(email);

		user.setPassword(password);

		user.setRole("user");//fix cung mac dinh role member

		UserDAO userDao = new UserDAOIMPL();
		userDao.add(user);
		/// chuyen huongS
		// server tra ve 1 duong dan url
		// client se goi sang duong dan moi
		resp.sendRedirect("/BTLWEB_N13/login-member");
	}
	}

}