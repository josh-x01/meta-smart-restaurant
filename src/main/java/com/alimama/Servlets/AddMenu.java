package com.alimama.Servlets;

import com.alimama.services.Menu;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alimama.data_util.servicesManager.MenuDataUtil;

/**
 * Servlet implementation class AddMenu
 */
@WebServlet("/AddMenu")
public class AddMenu extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		new MenuDataUtil().addMenu(new Menu(
				request.getParameter("name"),
				request.getParameter("category"),
				Float.parseFloat(request.getParameter("price")),
				request.getParameter("image")
				));
		response.sendRedirect("/alimama/success.jsp");
	}
	
}
