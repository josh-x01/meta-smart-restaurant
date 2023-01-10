package com.meta_restaurant;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import com.meta_restaurant.data_util.CustomerDataUtil;
import com.meta_restaurant.users.Customer;
import com.meta_restaurant.users.User;
import com.meta_restaurant.data_util.security.PasswordHash;
/**
 * Servlet implementation class Update
 */
public class Update extends HttpServlet {
	private String firstName, lastName, email, phone;
	private User user;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		firstName = request.getParameter("firstName");
		lastName = request.getParameter("lastName");
		email = request.getParameter("email");
		phone = request.getParameter("phone");
		// check if either of the field are null or empty
		if (firstName != null && lastName != null && email != null && phone != null) {
			if (firstName != "" && lastName != "" && email != "" && phone != "") {
				user = new Customer(firstName, lastName, email, phone,
						new PasswordHash().generateStorngPasswordHash(
								request.getParameter("password")
						));
				new CustomerDataUtil().updateUser(user);
			}
		}
		request.setAttribute("user", user);
		request.getRequestDispatcher("/dashboard.jsp")
				.forward(request, response);
	}
}
