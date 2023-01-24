package com.alimama.credential.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.alimama.data_util.BoardDataUtil;
import com.alimama.data_util.security.PasswordHash;
import com.alimama.mail.UserMailing;
import com.alimama.users.Board;

/**
 * Servlet implementation class Admin
 */
@WebServlet("/admin")
public class Admin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String firstName, lastName, email, phone, title;
	private boolean isValidPassword;
	Board board;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		response.sendRedirect("/alimama/board/admin.jsp");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		if (request.getParameter("admin-manager").equals("signup")) {
			firstName = request.getParameter("firstName");
			lastName = request.getParameter("lastName");
			phone = request.getParameter("phone");
			email = request.getParameter("email");
			title = request.getParameter("title");
			// check if either of the field are null or empty
			if (firstName != null && lastName != null && email != null && phone != null) {
				if (firstName != "" && lastName != "" && email != "" && phone != "") {
					new BoardDataUtil().createUser(
							new Board(firstName, lastName, phone, email,
									new PasswordHash().generateStorngPasswordHash(
											request.getParameter("password")),
											title));

					new UserMailing(email, firstName, lastName, phone, "welcome");
					response.sendRedirect("/alimama/board/admin.jsp");
				} else {
					response.sendRedirect("/alimama/board/add-admin.html");
				}
			} else {
				response.sendRedirect("/alimama/board/add-admin.html");
			}
		} else if (request.getParameter("admin-manager").equals("signin")) {
			// get email from request
			email = request.getParameter("email");
			// check if either of the field are null or empty
			if (email != null && email != "") {
				// get user data using email
				board = new BoardDataUtil().getUser(email);
				// check user is not null
				if (board != null) {
					// verify password
					isValidPassword = new PasswordHash().validatePassword(
							request.getParameter("password"),
							board.getHashedPassword());
					if (isValidPassword) {
						// send request and forward to services
						request.setAttribute("password", request.getParameter("password"));
						request.setAttribute("user", board);
						request.getRequestDispatcher("/board/admin-page.jsp")
								.forward(request, response);
					} else {
						response.sendRedirect("/alimama/board/admin.jsp");
					}
				} else {
					response.sendRedirect("/alimama/board/admin.jsp");
				}
			} else {
				response.sendRedirect("/alimama/board/admin.jsp");
			}
		}
	}
}