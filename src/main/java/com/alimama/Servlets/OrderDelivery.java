package com.alimama.Servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alimama.data_util.servicesManager.AddAddress;
import com.alimama.users.User;

/**
 * Servlet implementation class OrderDelivery
 */
@WebServlet("/OrderDelivery")
public class OrderDelivery extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String address = request.getParameter("address");
		int cid = ((User) request.getSession().getAttribute("userSession")).getId();
		
		new AddAddress().addAddress(cid, address);
		response.sendRedirect("/alimama/success.jsp");
	}

}
