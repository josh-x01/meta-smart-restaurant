package com.meta_restaurant.test;

import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import com.mysql.cj.jdbc.Blob;

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
	
	public BufferedImage getImage() {
    	Blob blob = null;
        String sql = "SELECT img FROM image WHERE id=5";
        
        try {
            prepareStatement = connection.prepareStatement(sql);
            resultSet = prepareStatement.executeQuery();
            if (resultSet.next()) {
                blob = (Blob) resultSet.getBlob("img");
            }
            return ImageIO.read(blob.getBinaryStream()) ;
        } catch (Exception e){
        	e.printStackTrace();
        }
        return null;
	}
	
	public Blob getBlob() {
    	Blob blob = null;
        String sql = "SELECT img FROM image WHERE id=5";
        
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
