package com.alimama.users;

public class Security {
	private int id;
	private String firstName, lastName, phone, email, hashedPassword, shift;
	
	public Security(int id, String firstName, String lastName, String phone, String email, String hashedPassword,
			String shift) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.email = email;
		this.hashedPassword = hashedPassword;
		this.shift = shift;
	}

	public Security(String firstName, String lastName, String phone, String email, String hashedPassword, String shift) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.email = email;
		this.hashedPassword = hashedPassword;
		this.shift = shift;
	}
	
	public Security() {
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
