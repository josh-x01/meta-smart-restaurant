package com.alimama.users;

public interface User {
	abstract int getId();
	abstract void setId(int id);
	abstract String getFirstName();
	abstract void setFirstName(String firstName);
	abstract String getLastName();
	abstract void setLastName(String lastName);
	abstract String getPhone();
	abstract void setPhone(String phone);
	abstract String getEmail();
	abstract void setEmail(String email);
	abstract String getHashedPassword();
	abstract void setHashedPassword(String hashedPassword);
	abstract String getShift();
	abstract void setShift(String shift);
	abstract String getStatus();
	abstract void setStatus(String status);
}
