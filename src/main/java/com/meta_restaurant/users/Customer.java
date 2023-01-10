package com.meta_restaurant.users;


public class Customer implements User{
	
	private String firstName, lastName, email, phone;
	private int id;

	public Customer(String fistName, String lastName, String email, String phone) {
		this.firstName = fistName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
	}
	
	public Customer(int id, String fistName, String lastName, String email, String phone) {
		this.id = id;
		this.firstName = fistName;
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

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String fistName) {
		this.firstName = fistName;
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
