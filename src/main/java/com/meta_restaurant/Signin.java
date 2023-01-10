package com.meta_restaurant;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import com.meta_restaurant.users.User;

import com.meta_restaurant.data_util.CustomerDataUtil;

/**
 * Servlet implementation class Signin
 */
public class Signin extends HttpServlet {
	private String email;
	private User user;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		response.sendRedirect("/metarestaurant/signin.html");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		email = request.getParameter("email");
		// check if either of the field are null or empty
		if (email != null && email != "") 
			user = new CustomerDataUtil().getUser(email);
		if (user != null) {
			request.setAttribute("user", user);
			request.getRequestDispatcher("/dashboard.jsp")
					.forward(request, response);
		}
	}

	
	
}
