package com.alimama.Servlets;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alimama.data_util.servicesManager.OrderDataUtil;
import com.alimama.data_util.servicesManager.OrdersManager;
import com.alimama.data_util.servicesManager.ReservationDataUtil;
import com.alimama.services.Order;
import com.alimama.services.Orders;
import com.alimama.services.Reservation;
import com.alimama.users.User;

/**
 * Servlet implementation class OrderReservation
 */
@WebServlet("/OrderReservation")
public class OrderReservation extends HttpServlet {
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
		String date = request.getParameter("date");
		String time = request.getParameter("time");
		String timestamp = date + " " + time + ":00";
		System.out.println(timestamp);
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("userSession");
		OrderDataUtil odu = new OrderDataUtil();
		ReservationDataUtil rdu = new ReservationDataUtil();
		String type = "reservation";

		int waiterId = 1;
		int recId = 1;
		float price = 100;
		Random rand = new Random();
		int tableId = rand.nextInt(100);
		
		int orderId = -1;
		
		if (user != null) {
			System.out.println("Adding Reservation order");
			odu.order(new Order(user.getId(), waiterId, tableId, price, type, timestamp));		
			orderId = odu.getLastOid();
			
			rdu.orderReservation(new Reservation(tableId, user.getId(), orderId, recId, timestamp));
		}
		response.sendRedirect("/alimama/success.jsp");
		
	}

}
