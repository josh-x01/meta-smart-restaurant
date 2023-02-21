package com.alimama.services;

public class Orders {
	int orderId, menuId;

	public Orders(int orderId, int menuId) {
		super();
		this.orderId = orderId;
		this.menuId = menuId;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getMenuId() {
		return menuId;
	}

	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}
	
}
