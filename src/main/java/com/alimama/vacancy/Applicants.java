package com.alimama.vacancy;

import java.io.IOException;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Applicants
 */
@WebServlet("/Applicants")
public class Applicants extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher rd = null; 
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/smart_restaurant","root","password");
			PreparedStatement pst = con.prepareStatement("insert into Applicants (fname,lname,phone,email,position,url) values(?,?,?,?,?,?) ");
			pst.setString(1, request.getParameter("name"));
			pst.setString(2, request.getParameter("name-1"));
			pst.setString(3, request.getParameter("phone"));
			pst.setString(4, request.getParameter("email"));
			pst.setString(5, request.getParameter("Position"));
			pst.setString(6, request.getParameter("url"));
			
			int rowCount = pst.executeUpdate();
			rd = request.getRequestDispatcher("Career.jsp");
			
			if(rowCount>0) {
				request.setAttribute("status", "Successful");
				
			}else {
				request.setAttribute("status", "Failed");
			}
			
			rd.forward(request, response);
			
			
		}catch(Exception e) 
			{e.printStackTrace();
		}
		finally {
			try {
				con.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}

		
		
		
		
	}

}
