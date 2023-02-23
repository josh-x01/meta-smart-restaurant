package com.alimama.data_util.servicesManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ServicesDataManager {
	// prepare variables
	Connection connection;
	Statement statement;
	PreparedStatement preparedStatement;
	ResultSet resultSet;
	String DBUsername = "alimama";
	String DBPassword = "alimama";
	String sql;
	// create a constructor for database connection
	public ServicesDataManager() {
		try {
//			System.out.println("Connecting alimama database ...");
			// register MYSQL JDBC driver
			Class.forName("com.mysql.jdbc.Driver");
			// create a connection
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/alimamadb", DBUsername, DBPassword);
			statement = connection.createStatement();
//			System.out.println("[OK] Successfully connected!");
		} catch (SQLException e) {
			System.err.println("[ERROR] Failed to connect with the alimama database!");
		} catch (Exception e) {
			System.err.println("[ERROR] Failed to register mysql driver!");
		}
	}
}
