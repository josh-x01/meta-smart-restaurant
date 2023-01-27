package com.alimama.data_util.servicesManager;

import com.alimama.services.Order;

public class OrderDataUtil extends ServicesDataManager {
	String table = "orderdetail";
	public boolean order(Order order) {
		// add try catch block		
		try {
			// create SQL statement
			sql = "INSERT INTO " + table
					+ " (cid, wid, tid, totalPrice, type) "
					+ "value(?,?,?,?,?)";
			// pass the SQL statement to prepared statement
			preparedStatement = connection.prepareStatement(sql);
			// add values from delivery
			preparedStatement.setInt(1, order.getCustomerId());
			preparedStatement.setInt(2, order.getWaiterId());
			preparedStatement.setInt(3, order.getTableId());
			preparedStatement.setFloat(4, order.getTotalPrice());
			preparedStatement.setString(5, order.getType());
			// execute query
			preparedStatement.execute();
			// Confirmation message
			System.out.println("[DONE] Order added to database successfully!");
			// return true
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean cancelOrder(int id) {
		// add try catch block		
		try {
			// create SQL statement
			sql = "DELETE FROM " + table + " WHERE oid = ?";
			// pass the SQL statement to prepared statement
			preparedStatement = connection.prepareStatement(sql);
			// add values from delivery
			preparedStatement.setInt(1, id);
			// execute query
			preparedStatement.execute();
			// Confirmation message
			System.out.println("[DONE] order removed successfully!");
			// return true
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
