package com.meta_restaurant;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import com.meta_restaurant.users.User;
import com.meta_restaurant.data_util.security.PasswordHash;

import com.meta_restaurant.data_util.CustomerDataUtil;

/**
 * Servlet implementation class Signin
 */
public class Signin extends HttpServlet {
	private String email;
	private User user;
	private boolean isValidPassword;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		response.sendRedirect("/metarestaurant/signin.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// get email from request
		email = request.getParameter("email");

		// check if either of the field are null or empty
		if (email != null && email != "") {
			// get user data using email
			user = new CustomerDataUtil().getUser(email);
			// check user is not null
			if (user != null) {
				// verify password
				isValidPassword = new PasswordHash().validatePassword(
						request.getParameter("password"),
						user.getHashedPassword());
				if (isValidPassword) {
					// send request and forward to services
					request.setAttribute("password", request.getParameter("password"));
					request.setAttribute("user", user);
					request.getRequestDispatcher("/services.jsp")
							.forward(request, response);
				} else {
					response.sendRedirect("/metarestaurant/signin.jsp");
				}
			} else {
				response.sendRedirect("/metarestaurant/signin.jsp");
			}
		} else {
			response.sendRedirect("/metarestaurant/signin.jsp");
		}

	}
}
