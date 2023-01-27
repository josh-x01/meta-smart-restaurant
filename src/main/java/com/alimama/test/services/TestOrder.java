package com.alimama.test.services;


import com.alimama.data_util.servicesManager.OrderDataUtil;
import com.alimama.services.Order;

public class TestOrder {

	public static void main(String[] args) {
		
		System.out.println("\n\nChecking order method");
		new OrderDataUtil().order(
			new Order(1, 1, 1, 100, "delivery")
		);

		System.out.println("\n\nChecking cancelOrder method");
		new OrderDataUtil().cancelOrder(5);
	}

}
