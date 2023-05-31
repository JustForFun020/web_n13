package org.btlweb.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.btlweb.dao.UserDAO;
import org.btlweb.dao.UserDAOIMPL;
import org.btlweb.model.UserLogin;

@WebServlet("/admin/user/update")
public class UpdateUserController extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UserDAO userDao = new UserDAOIMPL();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uid = req.getParameter("uid");

        UserLogin user = userDao.get(Integer.parseInt(uid));
        req.setAttribute("user", user);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/jsp/admin/user/updateUser.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("UserID");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String role = req.getParameter("role");
        String image = req.getParameter("image");

        UserLogin user = new UserLogin();
        user.setId(Integer.parseInt(id));
        user.setUsername(username);
        user.setPassword(password);
        user.setRole(role);
        user.setimage(image);

        userDao.update(user);

        resp.sendRedirect(req.getContextPath() + "/admin/user/search");
    }
}