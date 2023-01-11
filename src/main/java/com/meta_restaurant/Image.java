package com.meta_restaurant;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Base64;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Image
 */
public class Image extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection con = null;
		PreparedStatement ps = null;
		try {

			Class.forName("com.mysql.jdbc.Driver");
			 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc",
					"root", "root");
		       
			 String sql = "SELECT img FROM jdbc.image WHERE id=5";
		         ps = con.prepareStatement(sql);
		        
		         ResultSet rs = ps.executeQuery();

		        while (rs.next()) {
		            byte[] imgData = rs.getBytes("img"); // blob field 
		            request.setAttribute("rvi", "Ravinath");
		            rs.getString("teatitle");

		            String encode = Base64.getEncoder().encodeToString(imgData);
		            request.setAttribute("imgBase", encode);
		        }
			
			
			
			
			System.out.println("[OK] Successfully connected!");
		} catch (SQLException e) {
			System.err.println("[ERROR] Failed to connect with the meta database!");
		} catch (Exception e) {
			System.err.println("[ERROR] Failed to register mysql driver!");
		}
	}


}
