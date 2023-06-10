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


@WebServlet(urlPatterns = "/forgot") // ?errCode=100
public class ForgotPassword extends HttpServlet {

   
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String code = req.getParameter("errCode");

        if (code != null && code.equals("400")) {
            req.setAttribute("msg1", " Tài khoản không tồn tại");
        }

        RequestDispatcher dispatcher = req.getRequestDispatcher("/jsp/forgotpassword.jsp");
        dispatcher.forward(req, resp);
    }

   
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Đọc dữ liệu từ form gửi lên
        String email = req.getParameter("email");
        UserDAO userDao = new UserDAOIMPL();

        if (userDao.checkEmail(email)) {
            // Email tồn tại trong cơ sở dữ liệu, chuyển hướng đến trang thay đổi mật khẩu
        	System.out.println("Email đúng");
        	HttpSession session = req.getSession();
        	session.setAttribute("userEmail", email);
            resp.sendRedirect(req.getContextPath() + "/jsp/changepassword.jsp");
        } else {
        	System.out.println(" Email không tồn tại");
            // Email không tồn tại trong cơ sở dữ liệu, chuyển hướng đến trang đăng ký với mã lỗi
            resp.sendRedirect(req.getContextPath() + "/forgot?errCode=400");
        }
    }
}
