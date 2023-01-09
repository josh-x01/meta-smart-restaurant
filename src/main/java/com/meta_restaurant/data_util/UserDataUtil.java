package com.meta_restaurant.data_util;

import com.meta_restaurant.users.User;
import java.util.List;

public interface UserDataUtil {
	
	String DBRegister = "com.mysql.jdbc.Driver";
	String DBHost = "jdbc:mysql://localhost:3306/meta";
	
	User getUser(String id);
	void createUser(User user);
	void updateUser(User user);
	void deleteUser(String id);
	List<User> getAllUsers();
}
