package com.alimama.data_util.servicesManager;

import com.alimama.services.Delivery;

public class DeliveryDataUtil extends ServicesDataManager{
	String table = "delivery";
	Delivery delivery = new Delivery();
	public boolean orderDelivery(Delivery delivery) {
		// add try catch block
		try {
			// create SQL statement
			sql = "INSERT INTO " + table + " (oid, cid, dmid, address)"
					+ " VALUE (?,?,?,?)";
			// pass the SQL statement to prepared statement
			preparedStatement = connection.prepareStatement(sql);
			// add values from delivery
			preparedStatement.setInt(1, delivery.getOrderId());
			preparedStatement.setInt(2, delivery.getCustomerId());
			preparedStatement.setInt(3, delivery.getDeliverymanId());
			preparedStatement.setString(4, delivery.getAddress());
			// execute query
			preparedStatement.execute();
			// Confirmation message
			System.out.println("[DONE] Delivery add to database successfully!");
			// return true
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	public Delivery getDelivery(int id) {
		// add try catch block
		try {
			// create SQL statement
			sql = "SELECT * FROM " + table + " WHERE did = ?";
			// pass the SQL statement to prepared statement
			preparedStatement = connection.prepareStatement(sql);
			// add values from delivery
			preparedStatement.setInt(1, id);
			// execute query
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				// did oid cid dmid address time
				delivery.setDeliveryId(resultSet.getInt("did"));
				delivery.setOrderId(resultSet.getInt("oid"));
				delivery.setCustomerId(resultSet.getInt("cid"));
				delivery.setDeliverymanId(resultSet.getInt("dmid"));
				delivery.setAddress(resultSet.getString("address"));
				delivery.setTime((resultSet.getTimestamp("time")).toString());
			}
			// Confirmation message
			System.out.println("[DONE] Delivery retrived successfully!");
			// return delivery
			return delivery;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean cancelDelivery(int id) {
		// add try catch block
		try {
			// create SQL statement
			sql = "DELETE FROM " + table + " WHERE did = ?";
			// pass the SQL statement to prepared statement
			preparedStatement = connection.prepareStatement(sql);
			// add value to prepered statement
			preparedStatement.setInt(1, id);
			// execute query
			preparedStatement.execute();
			// Confirmation message
			System.out.println("[DONE] Delivery canceled successfully!");
			// return true
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return false;
	}
}
