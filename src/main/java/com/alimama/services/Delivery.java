package com.alimama.services;

public class Delivery {
	int deliveryId, orderId, customerId, deliverymanId;
	String address, time;
	
	public Delivery(int deliveryId, int orderId, int customerId, int deliverymanId, String address, String time) {
		this.deliveryId = deliveryId;
		this.orderId = orderId;
		this.customerId = customerId;
		this.deliverymanId = deliverymanId;
		this.address = address;
		this.time = time;
	}

	public Delivery(int orderId, int customerId, int deliverymanId, String address, String time) {
		super();
		this.orderId = orderId;
		this.customerId = customerId;
		this.deliverymanId = deliverymanId;
		this.address = address;
		this.time = time;
	}

	public Delivery(int orderId, int customerId, int deliverymanId, String address) {
		super();
		this.orderId = orderId;
		this.customerId = customerId;
		this.deliverymanId = deliverymanId;
		this.address = address;
	}

	public Delivery() {
		
	}
	
	public int getDeliveryId() {
		return deliveryId;
	}

	public void setDeliveryId(int deliveryId) {
		this.deliveryId = deliveryId;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public int getDeliverymanId() {
		return deliverymanId;
	}

	public void setDeliverymanId(int deliverymanId) {
		this.deliverymanId = deliverymanId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
}
