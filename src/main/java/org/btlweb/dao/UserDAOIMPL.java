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
		String sql = "UPDATE [BTLWEB].[dbo].[Users]  SET fullname=?, username=?, password=?, role=?, image=?, lastlogin=? ,email=? WHERE id=?";
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

	public int dayLogin(int userID) {
		int streak = 0;
		int dayLogin = 0;

		String updateQuery = "UPDATE [BTLWEB].[dbo].[Users] SET lastLogin = GETDATE() WHERE id = ?";

		try {
			conn = new JDBCUnit().getConnection();
			PreparedStatement updateStatement = conn.prepareStatement(updateQuery);
			updateStatement.setInt(1, userID);
			updateStatement.executeUpdate();
			updateStatement.close();

			String selectQuery = "SELECT DATEDIFF(DAY, lastLogin, GETDATE()) AS dayLogin FROM [BTLWEB].[dbo].[Users] WHERE id = ?";
			PreparedStatement selectStatement = conn.prepareStatement(selectQuery);
			selectStatement.setInt(1, userID);
			ResultSet resultSet = selectStatement.executeQuery();

			if (resultSet.next()) {
				dayLogin = resultSet.getInt("dayLogin");
				if (dayLogin == 0) {
					streak += 1;
				} else {
					streak = 0;
				}
			}

			resultSet.close();
			selectStatement.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return streak;
	}

	public int hourFocus(int userID) {
		int hour = 0;
		String query = "SELECT DATEPART(hour,DATEADD(minute, SUM(DATEDIFF(MINUTE, createAt, endAt)), '00:00:00')) AS Hour FROM [BTLWEB].[dbo].[TodoList] WHERE userID = ? and status='Done'";
		try {
			conn = new JDBCUnit().getConnection();
			PreparedStatement preparedStatement = conn.prepareStatement(query);
			preparedStatement.setInt(1, userID);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				hour = resultSet.getInt("Hour");
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return hour;
	}

	@Override
	public boolean checkEmail(String email) {
		String query = "SELECT COUNT(*) AS count FROM [BTLWEB].[dbo].[Users] WHERE email = ?";
		try {

			try {
				conn = new JDBCUnit().getConnection();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			PreparedStatement preparedStatement = conn.prepareStatement(query);
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
	public void updatePassword(String email, String newPassword) {
		try {
			// Kết nối đến cơ sở dữ liệu
			try {
				conn = new JDBCUnit().getConnection();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// Chuẩn bị câu truy vấn
			String query = "UPDATE [BTLWEB].[dbo].[Users] SET password = ? WHERE email = ?";
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
	public boolean checkUsernameExists(String username) {
		String sql = "SELECT COUNT(*) AS count FROM [BTLWEB].[dbo].[Users] WHERE username = ?";
		try {

			// Kết nối đến cơ sở dữ liệu
			try {
				conn = new JDBCUnit().getConnection();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
	public boolean checkUsername(String email, String username) {
		boolean isMatched = false;

		try {
			// Kết nối đến cơ sở dữ liệu
			try {
				conn = new JDBCUnit().getConnection();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// Chuẩn bị câu truy vấn
			String query = "SELECT username FROM [BTLWEB].[dbo].[Users] WHERE email = ?";
			PreparedStatement statement = conn.prepareStatement(query);

			// Thiết lập tham số cho câu truy vấn
			statement.setString(1, email);

			// Thực thi câu truy vấn
			ResultSet resultSet = statement.executeQuery();

			// Kiểm tra kết quả trả về
			if (resultSet.next()) {
				String storedUserName = resultSet.getString("username");
				// So sánh mật khẩu nhập vào với mật khẩu đã lưu trong cơ sở dữ liệu
				if (storedUserName.equals(username)) {
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

	public static void main(String[] args) {
		UserDAOIMPL daoimpl = new UserDAOIMPL();
		int a = daoimpl.hourFocus(3);
		System.out.println(a);
	}

}