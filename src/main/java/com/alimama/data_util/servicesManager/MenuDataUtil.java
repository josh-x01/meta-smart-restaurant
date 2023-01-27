package com.alimama.data_util.servicesManager;

import com.alimama.services.Menu;

public class MenuDataUtil extends ServicesDataManager{
	String table = "menu";
	public boolean addMenu(Menu menu) {
		// add try catch block		
		try {
			// create SQL statement
			sql = "INSERT INTO " + table
					+ " (name, category, price, description) "
					+ "value(?,?,?,?)";
			// pass the SQL statement to prepared statement
			preparedStatement = connection.prepareStatement(sql);
			// add values from delivery
			preparedStatement.setString(1, menu.getName());
			preparedStatement.setString(2, menu.getCategory());
			preparedStatement.setFloat(3, menu.getPrice());
			preparedStatement.setString(4, menu.getDescription());
			// execute query
			preparedStatement.execute();
			// Confirmation message
			System.out.println("[DONE] Menu added to database successfully!");
			// return true
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean removeMenu(int id) {
		// add try catch block		
		try {
			// create SQL statement
			sql = "DELETE FROM " + table + " WHERE mid = ?";
			// pass the SQL statement to prepared statement
			preparedStatement = connection.prepareStatement(sql);
			// add values from delivery
			preparedStatement.setInt(1, id);
			// execute query
			preparedStatement.execute();
			// Confirmation message
			System.out.println("[DONE] Menu removed successfully!");
			// return true
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
