package com.alimama.test;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class FileHandler {

	Connection connection;
	PreparedStatement prepareStatement;
	 ResultSet resultSet;
	

	public FileHandler() {
		try {
			System.out.println("Connecting meta database ...");
			// register MYSQL JDBC driver
			Class.forName("com.mysql.jdbc.Driver");
			// create a connection
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc",
					"root", "root");
			System.out.println("[OK] Successfully connected!");
		} catch (SQLException e) {
			System.err.println("[ERROR] Failed to connect with the meta database!");
		} catch (Exception e) {
			System.err.println("[ERROR] Failed to register mysql driver!");
		}
	}
	
	public Blob getImage() {
    	Blob blob = null;
        String sql = "SELECT img FROM image WHERE id=19";
        try {
            prepareStatement = connection.prepareStatement(sql);
            resultSet = prepareStatement.executeQuery();
            if (resultSet.next()) {
                blob = (Blob) resultSet.getBlob("img");
            }
        } catch (Exception e){
        	e.printStackTrace();
        }
        return blob;
	}
	
	
}
