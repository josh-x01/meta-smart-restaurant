package com.alimama.test.services;

import com.alimama.data_util.servicesManager.DeliveryDataUtil;
import com.alimama.services.Delivery;

public class TestDelivery {
	Delivery delivery;
	public static void main(String[] args) {
		System.out.println("Checking orderDelivery method");
		boolean result;
		Delivery delivery = new Delivery(3, 1, 1, "adama");
		result = new DeliveryDataUtil().orderDelivery(delivery);
		System.out.print(result);
		
		System.out.println("\n\nChecking getDelivery method");
		delivery = new DeliveryDataUtil().getDelivery(4);
		System.out.println(delivery.getTime());
		
		System.out.println("\n\nChecking cancelDelivery method");
		new DeliveryDataUtil().cancelDelivery(13);

	}
}
