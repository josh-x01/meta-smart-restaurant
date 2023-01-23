package com.alimama;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.alimama.data_util.*;
import com.alimama.data_util.security.PasswordHash;
import com.alimama.users.Customer;
import com.alimama.mail.CustomerMailing;
/**
 * Servlet implementation class Sign up
 */
public class Signup extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String firstName, lastName, email, phone;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		response.sendRedirect("/alimama/signup.html");
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
		new CustomerMailing(email, firstName, lastName, phone).welcome();
		response.sendRedirect("/alimama/signin.jsp");
	}
}
