package com.meta_restaurant.users;


public class Customer implements User{
	
	private String fistName, lastName, email, phone;
	private int id;

	public Customer(String fistName, String lastName, String email, String phone) {
		this.fistName = fistName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
	}
	
	public Customer(int id, String fistName, String lastName, String email, String phone) {
		this.id = id;
		this.fistName = fistName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
	}

	public Customer() {

	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFistName() {
		return fistName;
	}

	public void setFistName(String fistName) {
		this.fistName = fistName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
}
