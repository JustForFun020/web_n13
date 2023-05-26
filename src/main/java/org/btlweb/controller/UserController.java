package org.btlweb.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.btlweb.dao.UserDAO;
import org.btlweb.dao.UserDAOIMPL;
import org.btlweb.model.UserLogin;

@WebServlet("/admin/user/list")

public class UserController extends HttpServlet {
	
    private UserDAO userDAO;

    public UserController() {
        this.userDAO = new UserDAOIMPL();
    }
    
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<UserLogin> users = userDAO.getAllUsers();
        request.setAttribute("users", users);
        request.getRequestDispatcher("/jsp/admin/user/searchUser.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
    
    
}
