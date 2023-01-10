package com.meta_restaurant.test;

import java.util.ListIterator;

import com.meta_restaurant.data_util.CustomerDataUtil;
import com.meta_restaurant.users.Customer;
import com.meta_restaurant.users.User;

public class TestCustomer {
	public static void main(String[] args) {
		// checking CustomerDataUtil methods
		User user;
		System.out.println("checking CustomerDataUtil getAllUsers method");
		ListIterator<User> iterator = new CustomerDataUtil().getAllUsers().listIterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next().getId());
		}
		
		System.out.println("\n\nchecking CustomerDataUtil getUser method");
		System.out.println(new CustomerDataUtil().getUser("no").getId());
		
		System.out.println("\n\nchecking CustomerDataUtil createUser method");
//		user = new Customer("Nafrom", "Abera", "naf@gmail.com", "+25196587463");
//		new CustomerDataUtil().createUser(user);
		
		System.out.println("\n\nchecking CustomerDataUtil updateUser method");
		user = new Customer(25, "Nafiz", "tola", "naf@gmail.com", "+25196587463");
		new CustomerDataUtil().updateUser(user);
		
		System.out.println("\n\nchecking CustomerDataUtil deleteUser method");
		new CustomerDataUtil().deleteUser("21");
	}
}