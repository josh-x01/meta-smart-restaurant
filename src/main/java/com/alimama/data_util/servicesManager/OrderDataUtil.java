package com.alimama.data_util.servicesManager;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.alimama.services.Order;

public class OrderDataUtil extends ServicesDataManager {
	String table = "orderdetail";
	public boolean orderDelivery(Order order) {
		// add try catch block		
		try {
			// create SQL statement
			sql = "INSERT INTO " + table
					+ " (cid, wid, totalPrice, type) "
					+ "value(?,?,?,?)";
			// pass the SQL statement to prepared statement
			preparedStatement = connection.prepareStatement(sql);
			// add values from delivery
			preparedStatement.setInt(1, order.getCustomerId());
			preparedStatement.setInt(2, order.getWaiterId());
//			preparedStatement.setInt(3, order.getTableId());
			preparedStatement.setFloat(3, order.getTotalPrice());
			preparedStatement.setString(4, order.getType());
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
	
	public List<Order> getOrders() {
		List<Order> orders = new ArrayList<>();
		sql = "SELECT * FROM "+table;
		try {
			resultSet = statement.executeQuery(sql);
			while(resultSet.next()) {
				orders.add(new Order(
						resultSet.getInt(1),
						resultSet.getInt(2),
						resultSet.getInt(3),
						resultSet.getInt(4),
						resultSet.getFloat(5),
						resultSet.getString(6),
						resultSet.getTimestamp(7).toString()
						));
			}
			return orders;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public int getLastOid() {
		sql = "select oid from orderdetail ORDER BY oid DESC LIMIT 1";
		try {
			resultSet = statement.executeQuery(sql);
			if (resultSet.next()) {
				return resultSet.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
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
