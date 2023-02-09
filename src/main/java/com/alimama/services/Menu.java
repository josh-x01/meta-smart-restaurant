package com.alimama.services;

public class Menu {
	int menuId;
	String name, category;
	float price;
	String image;

	public Menu(int menuId, String name, String category, float price, String image) {
		super();
		this.menuId = menuId;
		this.name = name;
		this.category = category;
		this.price = price;
		this.image = image;
	}

	public Menu(String name, String category, float price, String image) {
		super();
		this.name = name;
		this.category = category;
		this.price = price;
		this.image = image;
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

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
}
