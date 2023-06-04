package org.btlweb.controller;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.btlweb.model.UserLogin;

import org.btlweb.dao.*;

import org.btlweb.jdbc.JDBCUnit;

@WebServlet(urlPatterns = "/change") // ?errCode=100
public class ChangePass extends HttpServlet {

   
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String code = req.getParameter("errCode");

        if (code != null && code.equals("400")) {
            req.setAttribute("msg1",  "Mật khẩu xác nhận không khớp");
        }if (code != null && code.equals("100")) {
            req.setAttribute("msg1",  "Mật khẩu  không chính xác");
        }

        RequestDispatcher dispatcher = req.getRequestDispatcher("/jsp/changepassword.jsp");
        dispatcher.forward(req, resp);
    }

   
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Đọc dữ liệu từ form gửi lên
    	String email = req.getParameter("email");
    	String password = req.getParameter("matkhau");
        String newPassword = req.getParameter("matkhaumoi");
        String confirmPassword = req.getParameter("xacnhanmatkhau");
        UserDAO userDao = new UserDAOIMPL();

        boolean isPasswordMatched =  userDao.checkPassword(email, password);

        if (!newPassword.equals(confirmPassword)) {
        	System.out.println("Mật khẩu xác nhận không khớp");
        	resp.sendRedirect(req.getContextPath() + "/change?errCode=400");
        }else if(isPasswordMatched) {
        	System.out.println("Okkkk");
        	userDao.updatePassword(email, newPassword);
        	resp.sendRedirect(req.getContextPath() + "/login-member");
        }else {
        	System.out.println("Mật khẩu  không chính xác");
          	resp.sendRedirect(req.getContextPath() + "/change?errCode=100");
        }
      
    
    }
}
