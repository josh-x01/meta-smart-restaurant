package com.alimama.test;

import java.util.ListIterator;

import com.alimama.data_util.CustomerDataUtil;
import com.alimama.users.Customer;
import com.alimama.users.User;


public class TestCustomerDataUtil {
	public static void main(String[] args) {
		// checking CustomerDataUtil methods
		User user;
		System.out.println("checking CustomerDataUtil getAllUsers method");
		ListIterator<User> iterator = new CustomerDataUtil().getAllUsers().listIterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next().getHashedPassword());
		}
		
		System.out.println("\n\nchecking CustomerDataUtil getUser method");
		System.out.println(new CustomerDataUtil().getUser("email3"));
		
//		System.out.println("\n\nchecking CustomerDataUtil createUser method");
//		user = new Customer("Nafrom", "Abera", "naf@gmail.com", "+25196587463", "1234567sdfghjk3456789uhgfd");
//		new CustomerDataUtil().createUser(user);
		
		System.out.println("\n\nchecking CustomerDataUtil updateUser method");
		user = new Customer("Nizasser", "tola",  "+78hhvyt7", "email2","1234567asdasdasdasdasdassdfghjk3456789uhgfd");
		new CustomerDataUtil().updateUser(user);
		
		System.out.println("\n\nchecking CustomerDataUtil deleteUser method");
		new CustomerDataUtil().deleteUser("email3");
	
//		Customer customer = new Customer("asd", "asdas", "asda", "asd", "asdasd");
//		System.out.println(customer.getHashedPassword());
	
	} 
	
	
	

}