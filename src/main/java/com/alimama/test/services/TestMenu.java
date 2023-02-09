package com.alimama.test.services;

import java.util.ListIterator;

import com.alimama.data_util.servicesManager.MenuDataUtil;
import com.alimama.services.Menu;

public class TestMenu {
	Menu menu;
	public static void main(String[] args) {
		
		System.out.println("\n\nChecking addMenu method");
		new MenuDataUtil().addMenu(
			new Menu("cake", "fast food", 80, "A very sweet cake")
		);
		
		System.out.println("\n\nChecking getMenu method");
		ListIterator<Menu> iterator = new MenuDataUtil().getMenu().listIterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next().getImage());
		}
		System.out.println("\n\nChecking removeMenu method");
		new MenuDataUtil().removeMenu(1);
		
	}

}
