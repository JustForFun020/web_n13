package org.btlweb.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.btlweb.model.UserSignup;
import org.btlweb.jdbc.JDBCUnit;

public class UserSignupDAO {
	Connection c = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	public UserSignup registerUser(String fullname,String username, String password, String email) {
		UserSignup newUser = null;
		String query = "INSERT INTO User (userID, fullname, username, password, role, lastLogin, email) VALUES (null,?, ?, ?,'user',GETDATE(), ?)";
		try {
			c = new JDBCUnit().getConnection();
			ps = c.prepareStatement(query);
			ps.setString(1, fullname);
            ps.setString(2, username);
            ps.setString(3, password);
            ps.setString(4, email);
            ps.executeUpdate();
            newUser = new UserSignup(fullname, username, password, email);
            newUser.setFullname(fullname);
            newUser.setUsername(username);
            newUser.setPassword(password);
            newUser.setEmail(email);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return newUser;
	}
}