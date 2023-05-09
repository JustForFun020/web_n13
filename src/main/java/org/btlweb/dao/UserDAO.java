package org.btlweb.dao;

import java.util.List;
import java.util.ArrayList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


import org.btlweb.model.UserAccounts;
import org.btlweb.jdbc.JDBCUnit;

public class UserDAO {
	Connection c = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	public List<UserAccounts> getAllUser() {
		List<UserAccounts> listUser = new ArrayList<>();
		String query = "select * from [WEB].[dbo].[nguoiDung]";
		try {
			// Mở kết nối với SQL
			c = new JDBCUnit().getConnection();
			ps = c.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next()) {
				listUser.add(new UserAccounts(
						// Lấy dữ liệu từ các cột 1, 3, 4, 5
						rs.getInt(1), 
						rs.getString(3), 
						rs.getString(4), 
						rs.getString(5)));
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return listUser;
	}
	
	public static void main(String[] args) {
		UserDAO userDAO = new UserDAO();
		List<UserAccounts> list = userDAO.getAllUser();
		for(UserAccounts o : list) {
			System.out.println(o);
		}
	}
}
