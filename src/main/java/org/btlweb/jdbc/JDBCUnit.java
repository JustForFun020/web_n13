package org.btlweb.jdbc;



import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCUnit {
	public Connection getConnection() {
		final String username = "root";
		final String password = "123456";
		final String url = "jdbc:mysql://localhost:3306/nhom13?createDatabaseIfNotExist=true&useUnicode=yes&characterEncoding=UTF-8";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			return DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			System.out.println("Ket noi failed " + e);
		}
		return null; 
	}
	
	public static void main(String[] args) {
		JDBCUnit jdbc = new JDBCUnit();
		Connection conn = jdbc.getConnection();
		if (conn == null) {
			System.out.println("THAT BAI");
		} else {
			System.out.println("THANH CONG");
		}
	}
}
