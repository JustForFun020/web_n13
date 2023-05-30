package org.btlweb.controller;

import java.io.IOException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.btlweb.dao.UserSignupDAO;
import org.btlweb.jdbc.JDBCUnit;

@WebServlet( urlPatterns = "/signup")
public class SignupController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	 public SignupController() {
		// TODO Auto-generated constructor stub
		 super();
	}
	 
	  @Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		  String fullname= req.getParameter("fullname_dangky");
		  String username=req.getParameter("taikhoan_dangky");
		  String password = req.getParameter("matkhau_dangky");
		  String email= req.getParameter("email_dangky");
		  UserSignupDAO user = new UserSignupDAO();
		  user.registerUser(fullname, username, password, email);
		  if(user != null) {
			  resp.sendRedirect(req.getContextPath() + "/jsp/login.jsp");
		  }
		  else {
			  System.out.println("NO");
		  }
	}
}
