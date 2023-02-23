package com.alimama.data_util.servicesManager;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.alimama.services.Menu;

public class MenuDataUtil extends ServicesDataManager{
	String table = "menu";
	List<Menu> menuLists = new ArrayList<>();

	public boolean addMenu(Menu menu) {
		// add try catch block		
		try {
			// create SQL statement
			sql = "INSERT INTO " + table
					+ " (name, category, price, image) "
					+ "value(?,?,?,?)";
			// pass the SQL statement to prepared statement
			preparedStatement = connection.prepareStatement(sql);
			// add values from delivery
			preparedStatement.setString(1, menu.getName());
			preparedStatement.setString(2, menu.getCategory());
			preparedStatement.setFloat(3, menu.getPrice());
			preparedStatement.setString(4, menu.getImage());
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
	
	public List<Menu> getMenu() {
		try {
			sql = "SELECT * FROM " + table;
			
			resultSet = statement.executeQuery(sql);
			
			while(resultSet.next()) {

				 menuLists.add(new Menu(
						 resultSet.getInt(1),
						 resultSet.getString(2),
						 resultSet.getString(3),
						 resultSet.getFloat(4),
						 resultSet.getString(5)
						 ));
			}
			
			return menuLists;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	
	public float getMenuPrice(int mid) {
		sql = "SELECT price FROM alimamadb.menu WHERE mid = ?";
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, mid);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				return resultSet.getFloat(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
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
