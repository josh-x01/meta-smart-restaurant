package com.alimama.test;

import java.util.ListIterator;

import com.alimama.data_util.BoardDataUtil;
import com.alimama.users.Board;

public class TestBoardDataUtil {
	public static void main(String[] args) {
		// checking BoardsDataUtil methods
		Board user;

		System.out.println("checking BoardsDataUtil getAllUsers method");
		ListIterator<Board> iterator = new BoardDataUtil().getAllUsers().listIterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next().getFirstName());
		}

		System.out.println("\n\nchecking BoardsDataUtil getUser method");
		System.out.println(new BoardDataUtil().getUser("email3").getFirstName());

//		System.out.println("\n\nchecking BoardsDataUtil createUser method");
//		user = new Board("Nafrom", "Abera", "+2519sad658asd7463","nafasdxc@gmail.com", "123sdf4567sdfzxczghjk3456789uhgfd", "accountant");
//		new BoardDataUtil().createUser(user);

		System.out.println("\n\nchecking BoardsDataUtil updateUser method");
		user = new Board("Nafiz", "tola",  "+78hhvyt7", "email2","1234567asdasdasdasdasdassdfghjk3456789uhgfd", "Manager");
		new BoardDataUtil().updateUser(user);

//		System.out.println("\n\nchecking BoardsDataUtil deleteUser method");
//		new BoardDataUtil().deleteUser("email1");

//		Board Board = new Board("asd", "asdas", "asda", "asd", "asdasd");
//		System.out.println(Board.getHashedPassword());
	
	} 
}