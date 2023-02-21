package com.alimama.Servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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

	HttpSession session;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] menuIds = request.getParameterValues("id");
		String type = request.getParameter("type");
		session = request.getSession();
		User user = (User) session.getAttribute("userSession");
		if (user != null) {
			System.out.println("Adding order");
			new OrderDataUtil().order(new Order(user.getId(), 1, 10 ,type));
		}
		
		
		if (menuIds != null) {
			for (String id : menuIds) {
				new OrdersManager().order(new Orders(14, Integer.parseInt(id)));
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
