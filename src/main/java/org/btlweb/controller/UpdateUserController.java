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

    private UserDAO userDao = new UserDAOIMPL();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uid = req.getParameter("uid");

        if (uid != null && !uid.isEmpty()) {
            int userId = Integer.parseInt(uid);
            UserLogin user = userDao.get(userId);

            if (user != null) {
                req.setAttribute("user", user);
            }
        }

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/jsp/admin/user/updateUser.jsp");
        requestDispatcher.forward(req, resp);
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

   

            UserLogin user = userDao.get(id);

            if (user != null) {
                user.setUsername(username);
                user.setPassword(password);
                user.setRole(role);
                user.setimage(image);

                userDao.update(user);
            }
        

        resp.sendRedirect(req.getContextPath() + "/admin/user/list");
    }
}
