package com.alimama.users;

public class Receptionist implements User {
	private String firstName, lastName, email, phone, hashedPassword, shift;
	private int id;
	
	public Receptionist(String firstName, String lastName, String email, String phone, String hashedPassword, String shift,
			int id) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
		this.hashedPassword = hashedPassword;
		this.shift = shift;
		this.id = id;
	}
	
	public Receptionist(String firstName, String lastName, String email, String phone, String hashedPassword, String shift) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
		this.hashedPassword = hashedPassword;
		this.shift = shift;
	}
	
	public Receptionist() {
	}

	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
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
	public String getHashedPassword() {
		return hashedPassword;
	}
	public void setHashedPassword(String hashedPassword) {
		this.hashedPassword = hashedPassword;
	}
	public String getShift() {
		return shift;
	}
	public void setShift(String shift) {
		this.shift = shift;
	}
	public String getStatus() {
		return null;
	}
	public void setStatus(String status) {
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}
