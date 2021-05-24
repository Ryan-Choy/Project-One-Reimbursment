package com.revature.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConnect {

	private static Connection connection;
	private static final String dbName = "postgres";
	private static final String hostName = System.getenv("URL");
	private static final String userName = System.getenv("USER_NAME");
	private static final String password = System.getenv("PASSWORD");
	private static final String url = hostName + ":" + 5432 + "/" + dbName + "?user=" + userName
			+ "&password=" + password;

//	jdbc:postgresql://jdbc:postgresql://database-1.ctwtl3iga44k.us-west-1.rds.amazonaws.com:5432/postgres?user=null&password=null

	public static Connection getConnection() throws SQLException {
		try {
	        Class.forName("org.postgresql.Driver");
	    } catch (ClassNotFoundException e) {
	        e.printStackTrace();
	    }
		if (connection == null || connection.isClosed()) {
		
				connection = DriverManager.getConnection(url);
			
				// TODO Auto-generated catch block
				
			
		}
		
		return connection;
	}

}
