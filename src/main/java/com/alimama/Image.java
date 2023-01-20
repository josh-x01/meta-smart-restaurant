package com.alimama;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Base64;



import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class Image
 */
public class Image extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection con = null;
		PreparedStatement ps = null;
		File image = new File("https://i.ibb.co/fHcpNhj/smart-restaurant.jpg");
		FileInputStream fis = new FileInputStream(image);
		try {

			Class.forName("com.mysql.jdbc.Driver");
			 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc",
					"root", "root");
		       
			 String sql = "insert into image (img) value(?)";
		         ps = con.prepareStatement(sql);
		        
		         ps.setBlob(1, (InputStream) fis, (int) (image.length()) );
		         
		         ps.execute();
			
			System.out.println("[OK] Successfully Uploaded!");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			System.err.println("[ERROR] Failed to register mysql driver!");
		}
	}


}