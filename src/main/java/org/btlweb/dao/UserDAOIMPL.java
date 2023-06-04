package org.btlweb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.btlweb.jdbc.JDBCUnit;
import org.btlweb.model.UserLogin;

import org.btlweb.jdbc.JDBCUnit;

public class UserDAOIMPL extends JDBCUnit implements UserDAO {
	Connection conn = null;

	@Override
	public void add(UserLogin user) {
		String sql = "INSERT INTO [BTLWEB].[dbo].[Users] ( fullname, username, password, role, image, lastlogin, email) VALUES ( ?, ?, ?, ?, 'https://icons.veryicon.com/png/o/internet--web/prejudice/user-128.png', GETDATE(),?)";
		try {
			try {
				conn = new JDBCUnit().getConnection();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			PreparedStatement preparedStatement = conn.prepareStatement(sql);

			preparedStatement.setString(1, user.getfullName());
			preparedStatement.setString(2, user.getUsername());
			preparedStatement.setString(3, user.getPassword());
			preparedStatement.setString(4, user.getRole());
			preparedStatement.setString(5, user.getemail());

			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Error: " + e);
		}
	}

	@Override
	public void update(UserLogin user) {
		String sql = "UPDATE [BTLWEB].[dbo].[Users]  SET fullname=?, username=?, password=?, role=?, image=?, lastlogin=? ,email=? WHERE userID=?";
		try {
			try {
				conn = new JDBCUnit().getConnection();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			PreparedStatement preparedStatement = conn.prepareStatement(sql);

			preparedStatement.setString(1, user.getfullName());
			preparedStatement.setString(2, user.getUsername());
			preparedStatement.setString(3, user.getPassword());
			preparedStatement.setString(4, user.getRole());
			preparedStatement.setString(5, user.getimage());
			preparedStatement.setString(6, user.getLastLogin());
			preparedStatement.setString(7, user.getemail());
			preparedStatement.setInt(8, user.getUserID());

			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Error: " + e);
		}
	}

	@Override

	public void delete(int id) {
		String sql = "DELETE FROM [BTLWEB].[dbo].[Users]  WHERE id = ?";

		try {
			try {
				conn = new JDBCUnit().getConnection();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			PreparedStatement preparedStatement = conn.prepareStatement(sql);

			preparedStatement.setInt(1, id);

			preparedStatement.executeUpdate();

		} catch (Exception e) {
			System.out.println("Loi: " + e);
		}
	}

	@Override
	public List<UserLogin> getAllUsers() {
		List<UserLogin> users = new ArrayList<>();

		String sql = "SELECT * FROM [BTLWEB].[dbo].[Users] ";
		try {
			try {
				conn = new JDBCUnit().getConnection();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			PreparedStatement preparedStatement = conn.prepareStatement(sql);

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				users.add(rowMapper(resultSet));
			}
		} catch (SQLException e) {
			System.out.println("Error: " + e);
		}

		return users;
	}

	@Override
	public UserLogin get(int id) {
		String sql = "SELECT * FROM [BTLWEB].[dbo].[Users]  WHERE id = ?";

		try {
			try {
				conn = new JDBCUnit().getConnection();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			PreparedStatement preparedStatement = conn.prepareStatement(sql);

			preparedStatement.setInt(1, id);

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				return rowMapper(resultSet);
			}

		} catch (Exception e) {
			System.out.println("Loi: " + e);
		}

		return null;
	}

	@Override
	public List<UserLogin> search(String fullName) {
		List<UserLogin> users = new ArrayList<>();

		String sql = "SELECT * FROM [BTLWEB].[dbo].[Users]  WHERE fullName LIKE ?";
		try {
			try {
				conn = new JDBCUnit().getConnection();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			PreparedStatement preparedStatement = conn.prepareStatement(sql);

			preparedStatement.setString(1, "%" + fullName + "%");

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				users.add(rowMapper(resultSet));
			}
		} catch (Exception e) {
			System.out.println("Loi: " + e);
		}

		return users;
	}

	@Override
	public UserLogin getByUsername(String username) {
		String sql = "SELECT * FROM [BTLWEB].[dbo].[Users]  WHERE username = ?";

		try {
			try {
				conn = new JDBCUnit().getConnection();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			PreparedStatement preparedStatement = conn.prepareStatement(sql);

			preparedStatement.setString(1, username);

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				return rowMapper(resultSet);
			}

		} catch (Exception e) {
			System.out.println("Loi: " + e);
		}

		return null;
	}

	private UserLogin rowMapper(ResultSet resultSet) throws SQLException {

		UserLogin user = new UserLogin();
		user.setUserID(resultSet.getInt("id"));
		user.setfullName(resultSet.getString("fullName"));
		user.setUsername(resultSet.getString("username"));
		user.setPassword(resultSet.getString("password"));
		user.setRole(resultSet.getString("role"));
		user.setimage(resultSet.getString("image"));
		user.setLastLogin(resultSet.getString("lastlogin"));
		user.setemail(resultSet.getString("email"));
		return user;
	}

}