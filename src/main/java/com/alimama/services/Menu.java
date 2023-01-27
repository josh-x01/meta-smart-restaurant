package com.alimama.services;

public class Menu {
	int menuId;
	String name, category;
	float price;
	String description;

	public Menu(int menuId, String name, String category, float price, String description) {
		super();
		this.menuId = menuId;
		this.name = name;
		this.category = category;
		this.price = price;
		this.description = description;
	}

	public Menu(String name, String category, float price, String description) {
		super();
		this.name = name;
		this.category = category;
		this.price = price;
		this.description = description;
	}

	public int getMenuId() {
		return menuId;
	}

	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
