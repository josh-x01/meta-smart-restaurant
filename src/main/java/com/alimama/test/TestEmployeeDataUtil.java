package com.alimama.test;

import java.util.ListIterator;

import com.alimama.data_util.EmployeeDataUtil;
import com.alimama.users.Employee;
import com.alimama.users.User;

public class TestEmployeeDataUtil {
	public static void main(String[] args) {
		// checking EmployeesDataUtil methods
		User user;
		String table = "deliveryman";
		System.out.println("checking EmployeesDataUtil getAllUsers method");
		ListIterator<User> iterator = new EmployeeDataUtil(table).getAllUsers().listIterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next().getFirstName());
		}
		
		System.out.println("\n\nchecking EmployeesDataUtil getUser method");
		System.out.println(new EmployeeDataUtil(table).getUser("email3").getFirstName());
		
		System.out.println("\n\nchecking EmployeesDataUtil createUser method");
		user = new Employee("Nafrom", "Abera", "+2519sad658asd7463","nafasdxc@gmail.com", "123sdf4567sdfzxczghjk3456789uhgfd", "night", "busy");
		new EmployeeDataUtil(table).createUser(user);
		
		System.out.println("\n\nchecking EmployeesDataUtil updateUser method");
		user = new Employee("Nafiz", "tola",  "+78hhvyt7", "email1","1234567asdasdasdasdasdassdfghjk3456789uhgfd", "night", "busy");
		new EmployeeDataUtil(table).updateUser(user);
		
		System.out.println("\n\nchecking EmployeesDataUtil deleteUser method");
		new EmployeeDataUtil(table).deleteUser("email1");
	
//		Employee Employee = new Employee("asd", "asdas", "asda", "asd", "asdasd");
//		System.out.println(Employee.getHashedPassword());
	
	} 
}

