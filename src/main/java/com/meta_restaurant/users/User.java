package com.meta_restaurant.users;

public interface User {
	abstract int getId();
	abstract void setId(int id);
	abstract String getFirstName();
	abstract void setFirstName(String fistName);
	abstract String getLastName();
	abstract void setLastName(String lastName);
	abstract String getEmail();
	abstract void setEmail(String email);
	abstract String getPhone();
	abstract void setPhone(String phone);
}
