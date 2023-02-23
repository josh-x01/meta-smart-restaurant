package com.alimama.services;

public class Reservation {
	int reservationId, tableId, customerId, orderId, receptionId;
	String time;

	public Reservation(int reservationId, int tableId, int customerId, int orderId, int receptionId, String time) {
		super();
		this.reservationId = reservationId;
		this.tableId = tableId;
		this.customerId = customerId;
		this.orderId = orderId;
		this.receptionId = receptionId;
		this.time = time;
	}

	public Reservation(int tableId, int customerId, int orderId, int receptionId, String time) {
		super();
		this.tableId = tableId;
		this.customerId = customerId;
		this.orderId = orderId;
		this.receptionId = receptionId;
		this.time = time;
	}

	public Reservation(int tableId, int customerId, int orderId, int receptionId) {
		super();
		this.tableId = tableId;
		this.customerId = customerId;
		this.orderId = orderId;
		this.receptionId = receptionId;
	}
	
	public Reservation() {
		
	}

	public int getReservationId() {
		return reservationId;
	}

	public void setReservationId(int reservationId) {
		this.reservationId = reservationId;
	}

	public int getTableId() {
		return tableId;
	}

	public void setTableId(int tableId) {
		this.tableId = tableId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getReceptionId() {
		return receptionId;
	}

	public void setReceptionId(int receptionId) {
		this.receptionId = receptionId;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
}