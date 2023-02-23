package com.alimama.Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alimama.data_util.servicesManager.MenuDataUtil;
import com.alimama.data_util.servicesManager.OrderDataUtil;
import com.alimama.data_util.servicesManager.OrdersManager;
import com.alimama.services.Order;
import com.alimama.services.Orders;
import com.alimama.users.User;

/**
 * Servlet implementation class OrderServlet
 */
@WebServlet("/orders")
public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] menuIds = request.getParameterValues("id");
		String type = request.getParameter("type");
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("userSession");
		OrderDataUtil odu = new OrderDataUtil();
		MenuDataUtil mdu = new MenuDataUtil();
		int orderId = -1;
		float totalPrice = 0;
		float menuPrice;
		Random rand = new Random();
		int tableId = rand.nextInt(100);
		
		for (String mid : menuIds) {
			menuPrice = mdu.getMenuPrice(Integer.parseInt(mid));
			totalPrice += menuPrice;
		}
		
		
		if (user != null) {
			System.out.println("Adding order");
			if (type.equals("delivery")) {
				odu.orderDelivery(new Order(user.getId(), 1, totalPrice ,type));
			} else {
				odu.order(new Order(user.getId(), 1, tableId, totalPrice ,type));
			}
				
			orderId = odu.getLastOid();
			
			
			
			if (menuIds != null && orderId != -1) {
				for (String id : menuIds) {
					new OrdersManager().order(new Orders(orderId, Integer.parseInt(id)));
				}
			}
		}
		response.sendRedirect("/alimama/success.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
