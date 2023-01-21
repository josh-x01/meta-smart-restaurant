package com.justfortesting.registration;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet("/register")
public class registrationServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		PrintWriter out = response.getWriter();
//		out.print("working");
		
		String uname =request.getParameter("name");
		String uemail = request.getParameter("email");
		String upass = request.getParameter("pass");
		String umobile = request.getParameter("contact");
		
		RequestDispatcher rd = null; 
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/smart_restaurant?useSSL=false","root","password");
			PreparedStatement pst = con.prepareStatement("insert into customer (uname,uemail, upass, umobile) values(?,?,?,?) ");
			pst.setString(1, uname);
			pst.setString(2,uemail);
			pst.setString(3,upass);
			pst.setString(4,umobile);
			
			int rowCount = pst.executeUpdate();
			rd = request.getRequestDispatcher("registration.jsp");
			
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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	private static final long serialVersionUID = 1L;
    public registrationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

}
