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
			System.out.println(iterator.next().getHashedPassword());
		}
		
		System.out.println("\n\nchecking CustomerDataUtil getUser method");
		System.out.println(new CustomerDataUtil().getUser("naf@gmail.com"));
		
//		System.out.println("\n\nchecking CustomerDataUtil createUser method");
//		user = new Customer("Nafrom", "Abera", "naf@gmail.com", "+25196587463", "1234567sdfghjk3456789uhgfd");
//		new CustomerDataUtil().createUser(user);
		
		System.out.println("\n\nchecking CustomerDataUtil updateUser method");
		user = new Customer("Nizasser", "tola", "coka@gmail.com", "+78hhvyt7", "1234567asdasdasdasdasdassdfghjk3456789uhgfd");
		new CustomerDataUtil().updateUser(user);
		
		System.out.println("\n\nchecking CustomerDataUtil deleteUser method");
		new CustomerDataUtil().deleteUser("coka@gmail.com");
	
//		Customer customer = new Customer("asd", "asdas", "asda", "asd", "asdasd");
//		System.out.println(customer.getHashedPassword());
	
	} 
	
	
	

}