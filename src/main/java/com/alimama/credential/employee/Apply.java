package com.alimama.credential.employee;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.alimama.data_util.EmployeeDataUtil;
import com.alimama.data_util.security.PasswordHash;
import com.alimama.mail.UserMailing;
import com.alimama.users.Employee;

/**
 * Servlet implementation class Apply
 */
@WebServlet("/apply")
public class Apply extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String firstName, lastName, email, phone;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		response.sendRedirect("/alimama/employee/apply.jsp");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		firstName = request.getParameter("firstName");
		lastName = request.getParameter("lastName");
		phone = request.getParameter("phone");
		email = request.getParameter("email");
		// check if either of the field are null or empty
		if (firstName != null && lastName != null && email != null && phone != null) {
			if (firstName != "" && lastName != "" && email != "" && phone != "") {
				new EmployeeDataUtil(request.getParameter("job")).createUser(
						new Employee(firstName, lastName, phone, email,
								new PasswordHash().generateStorngPasswordHash(
										request.getParameter("password")),
										"n/a", "n/a"));

				new UserMailing(email, firstName, lastName, phone, "welcome");
				response.sendRedirect("/alimama/signin.jsp");
			} else {
				response.sendRedirect("/alimama/signup.html");
			}
		} else {
			response.sendRedirect("/alimama/signup.html");
		}
	}
}