package com.alimama.users;

public class Board implements User{
	private int id;
	private String firstName, lastName, email, phone, hashedPassword, title;

	public Board(String fistName, String lastName, String phone, String email, String hashedPassword, String title) {
		this.firstName = fistName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
		this.hashedPassword = hashedPassword;
		this.title = title;
	}

	public Board(int id, String fistName, String lastName, String phone, String email, String hashedPassword, String title) {
		this.id = id;
		this.firstName = fistName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
		this.hashedPassword = hashedPassword;
		this.title = title;
	}

	public Board() {

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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getShift() {
		return null;
	}
	public void setShift(String shift) {
	}
	public String getStatus() {
		return null;
	}
	public void setStatus(String status) {
	}
}