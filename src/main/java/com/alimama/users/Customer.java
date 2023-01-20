package com.alimama.users;


public class Customer implements User{
	
	private String firstName, lastName, email, phone, hashedPassword;
	private int id;

	public Customer(String fistName, String lastName, String email, String phone, String hashedPassword) {
		this.firstName = fistName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
		this.hashedPassword = hashedPassword;
	}

	public Customer(int id, String fistName, String lastName, String email, String phone,  String hashedPassword) {
		this.id = id;
		this.firstName = fistName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
		this.hashedPassword = hashedPassword;
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getHashedPassword() {
		return hashedPassword;
	}

	public void setHashedPassword(String hashedPassword) {
		this.hashedPassword = hashedPassword;
	}
}
