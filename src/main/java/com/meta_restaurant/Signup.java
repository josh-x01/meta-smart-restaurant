package com.meta_restaurant;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import com.meta_restaurant.data_util.*;
import com.meta_restaurant.data_util.security.PasswordHash;
import com.meta_restaurant.users.Customer;
/**
 * Servlet implementation class Sign up
 */
public class Signup extends HttpServlet {
	private String firstName, lastName, email, phone;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		response.sendRedirect("/metarestaurant/signup.html");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		firstName = request.getParameter("firstName");
		lastName = request.getParameter("lastName");
		email = request.getParameter("email");
		phone = request.getParameter("phone");
		// check if either of the field are null or empty
		if (firstName != null && lastName != null && email != null && phone != null) {
			if (firstName != "" && lastName != "" && email != "" && phone != "")
				new CustomerDataUtil().createUser(new Customer(
						firstName, lastName, email, phone,
						new PasswordHash().generateStorngPasswordHash(
								request.getParameter("password"))
						));
		}

		response.sendRedirect("/metarestaurant/signin.html");
	}
}
