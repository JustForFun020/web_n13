package org.btlweb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.btlweb.jdbc.JDBCUnit;
import org.btlweb.model.UserLogin;

public class UserDAOIMPL extends JDBCUnit implements UserDAO {

	@Override
	public void add(UserLogin user) {
		String sql = "INSERT INTO users (userID, fullname, username, password, role, image, email) VALUES (?, ?, ?, ?, ?, ?,?)";
		try {
			Connection conn = super.getConnection();
			PreparedStatement preparedStatement = conn.prepareStatement(sql);

			preparedStatement.setInt(1, user.getUserID());
			preparedStatement.setString(2, user.getfullName());
			preparedStatement.setString(3, user.getUsername());
			preparedStatement.setString(4, user.getPassword());
			preparedStatement.setString(5, user.getRole());
			preparedStatement.setString(6, user.getimage());
			
			preparedStatement.setString(7, user.getemail());

			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Error: " + e);
		}
	}

	@Override
	public void update(UserLogin user) {
		String sql = "UPDATE users SET fullname=?, username=?, password=?, role=?, image=?,email=? WHERE userID=?";
		try {
			Connection conn = super.getConnection();
			PreparedStatement preparedStatement = conn.prepareStatement(sql);

			preparedStatement.setString(1, user.getfullName());
			preparedStatement.setString(2, user.getUsername());
			preparedStatement.setString(3, user.getPassword());
			preparedStatement.setString(4, user.getRole());
			preparedStatement.setString(5, user.getimage());
			
			preparedStatement.setString(6, user.getemail());
			preparedStatement.setInt(7, user.getUserID());

			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Error: " + e);
		}
	}

	@Override

	public void delete(int id) {
		String sql = "DELETE FROM users WHERE userID = ?";

		try {
			Connection conn = super.getConnection();
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

		String sql = "SELECT * FROM users";
		try {
			Connection conn = super.getConnection();
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
		String sql = "SELECT * FROM users WHERE userID = ?";

		try {
			Connection conn = super.getConnection();

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

		String sql = "SELECT * FROM users WHERE fullName LIKE ?";
		try {
			Connection conn = super.getConnection();
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
	public boolean checkUsernameExists(String username) {
		String sql = "SELECT COUNT(*) AS count FROM users WHERE username = ?";
		try {

			Connection conn = super.getConnection();
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, username);

			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				int count = resultSet.getInt("count");
				return count > 0;
			}
		} catch (SQLException e) {
			System.out.println("Loi: " + e);
		}

		return false;
	}

	@Override
	public boolean checkEmail(String email) {
		String sql = "SELECT COUNT(*) AS count FROM users WHERE email = ?";
		try {

			Connection conn = super.getConnection();
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, email);

			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				int count = resultSet.getInt("count");
				return count > 0;
			}
		} catch (SQLException e) {
			System.out.println("Loi: " + e);
		}

		return false;
	}

	@Override
	public UserLogin getByUsername(String username) {
		String sql = "SELECT * FROM users WHERE username = ?";

		try {
			Connection conn = super.getConnection();

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

	@Override
	public void updatePassword(String email, String newPassword) {
		try {
			// Kết nối đến cơ sở dữ liệu
			Connection conn = super.getConnection();

			// Chuẩn bị câu truy vấn
			String query = "UPDATE users SET password = ? WHERE email = ?";
			PreparedStatement statement = conn.prepareStatement(query);

			// Thiết lập các tham số cho câu truy vấn
			statement.setString(1, newPassword);
			statement.setString(2, email);

			// Thực thi câu truy vấn
			statement.executeUpdate();

			// Đóng kết nối và giải phóng tài nguyên
			statement.close();
			conn.close();
		} catch (SQLException e) {
			// Xử lý ngoại lệ nếu có lỗi xảy ra
			System.out.println("Loi: " + e);
		}
	}
	@Override
	public boolean checkPassword(String email, String password) {
		boolean isMatched = false;

		try {
			// Kết nối đến cơ sở dữ liệu
			Connection conn = super.getConnection();

			// Chuẩn bị câu truy vấn
			String query = "SELECT password FROM users WHERE email = ?";
			PreparedStatement statement = conn.prepareStatement(query);

			// Thiết lập tham số cho câu truy vấn
			statement.setString(1, email);

			// Thực thi câu truy vấn
			ResultSet resultSet = statement.executeQuery();

			// Kiểm tra kết quả trả về
			if (resultSet.next()) {
				String storedPassword = resultSet.getString("password");
				// So sánh mật khẩu nhập vào với mật khẩu đã lưu trong cơ sở dữ liệu
				if (storedPassword.equals(password)) {
					isMatched = true;
				}
			}

			// Đóng kết nối và giải phóng tài nguyên
			resultSet.close();
			statement.close();
			conn.close();
		} catch (SQLException e) {
			// Xử lý ngoại lệ nếu có lỗi xảy ra
			e.printStackTrace();
		}

		return isMatched;
	}

	private UserLogin rowMapper(ResultSet resultSet) throws SQLException {

		UserLogin user = new UserLogin();
		user.setUserID(resultSet.getInt("userID"));
		user.setfullName(resultSet.getString("fullName"));

		user.setUsername(resultSet.getString("username"));
		user.setPassword(resultSet.getString("password"));
		user.setRole(resultSet.getString("role"));
		user.setimage(resultSet.getString("image"));
		
		user.setemail(resultSet.getString("email"));
		return user;
	}

}
