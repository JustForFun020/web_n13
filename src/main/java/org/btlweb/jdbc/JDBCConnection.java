package org.btlweb.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;



public class JDBCConnection {
	public Connection getConnection() throws Exception {
		String url = "jdbc:sqlserver://"+serverName+":"+portNumber +";instance="+ instance + "databaseName="+dbName+ ";encrypt=true;trustServerCertificate=true";
		if(instance == null || instance.trim().isEmpty())
			url = "jdbc:sqlserver://"+serverName+":"+portNumber + "databaseName="+dbName+ ";encrypt=true;trustServerCertificate=true";
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		return DriverManager.getConnection(url, userName, password);
	}
	private final String serverName = "localhost";
	private final String dbName = "WEB";
	private final String portNumber = "1433";
	private final String instance = "TRUONGHT";
	private final String userName = "sa";
	private final String password = "123";
	public static void main(String[] args) {
		try {
			System.out.println(new JDBCConnection().getConnection());
			System.out.println("Sucess");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}
}
