package com.revature.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {

	private static Connection con;
	
	public static Connection getConnection() throws SQLException {
		// Use environment variables to create connection.
		
		String url = System.getenv("PG_DB_URL");
		String username = System.getenv("PG_DB_USERNAME");
		String password = System.getenv("PG_DB_PASSWORD");
		
		if (con == null || con.isClosed()) {
			con = DriverManager.getConnection(url, username, password);
		}
		return con;
	}
}
