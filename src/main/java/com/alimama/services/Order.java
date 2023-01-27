package com.alimama.services;

public class Order {
	int orderId, customerId, waiterId, tableId;
	float totalPrice;
	String type;
	
	public Order(int orderId, int customerId, int waiterId, int tableId, float totalPrice, String type) {
		super();
		this.orderId = orderId;
		this.customerId = customerId;
		this.waiterId = waiterId;
		this.tableId = tableId;
		this.totalPrice = totalPrice;
		this.type = type;
	}

	public Order(int customerId, int waiterId, int tableId, float totalPrice, String type) {
		super();
		this.customerId = customerId;
		this.waiterId = waiterId;
		this.tableId = tableId;
		this.totalPrice = totalPrice;
		this.type = type;
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

	public int getWaiterId() {
		return waiterId;
	}

	public void setWaiterId(int waiterId) {
		this.waiterId = waiterId;
	}

	public int getTableId() {
		return tableId;
	}

	public void setTableId(int tableId) {
		this.tableId = tableId;
	}

	public float getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
