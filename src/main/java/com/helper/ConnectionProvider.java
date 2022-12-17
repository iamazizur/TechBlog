package com.helper;

import java.sql.*;


public class ConnectionProvider {
	
	
	
	private static Connection connection;
	
	public static Connection getConnection() {
		if(connection != null) return connection;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/techblog", "root", "Aziz@1234");
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
		return connection;
	}
	
}
