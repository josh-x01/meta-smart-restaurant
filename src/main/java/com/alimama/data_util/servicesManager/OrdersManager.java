package com.alimama.data_util.servicesManager;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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
	
	public List<Orders> getOrders() {
		List<Orders> orders = new ArrayList<>();
		sql = "SELECT * FROM "+table;
		try {
			resultSet = statement.executeQuery(sql);
			while(resultSet.next()) {
				orders.add(new Orders(
						resultSet.getInt(1),
						resultSet.getInt(2)
						));
			}
			return orders;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public String getOrders(int oid) {
		sql = "SELECT * FROM "+table+" WHERE oid = " + oid;
		String orders = "";
		try {
			resultSet = statement.executeQuery(sql);
			while(resultSet.next()) {
				orders += resultSet.getInt(2) +" ";
						
			}
			return orders;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
