package com.alimama.data_util;

import com.alimama.users.User;
import java.util.List;

public interface UserDataUtil {
	
	public String DBRegister = "com.mysql.jdbc.Driver";
	public String DBHost = "jdbc:mysql://localhost:3306/alimamadb";
	
	<T> User getUser(T t);
	void createUser(User user);
	void updateUser(User user);
	<T> void deleteUser(T t);
	List<User> getAllUsers();
}
