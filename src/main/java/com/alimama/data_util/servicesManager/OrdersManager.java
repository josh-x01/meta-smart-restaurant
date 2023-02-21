package com.alimama.data_util.servicesManager;

import com.alimama.services.Orders;

public class OrdersManager extends ServicesDataManager{
	String table = "orders";
	public boolean order(Orders order) {
		// add try catch block		
		try {
			// create SQL statement
			sql = "INSERT INTO " + table
					+ " (oid, mid) "
					+ "value(?,?)";
			// pass the SQL statement to prepared statement
			preparedStatement = connection.prepareStatement(sql);
			// add values from delivery
			preparedStatement.setInt(1, order.getOrderId());
			preparedStatement.setInt(2, order.getMenuId());
			// execute query
			preparedStatement.execute();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
