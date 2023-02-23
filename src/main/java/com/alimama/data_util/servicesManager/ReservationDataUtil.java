package com.alimama.data_util.servicesManager;


import com.alimama.services.Reservation;

import java.sql.SQLException;
import java.sql.Timestamp;

public class ReservationDataUtil extends ServicesDataManager{
	String table = "reservation";
	public boolean orderReservation(Reservation reservation) {
		// add try catch block		
		try {
			// create SQL statement
			sql = "INSERT INTO " + table
					+ " (tid, cid, oid, recid, time) "
					+ "value(?,?,?,?,?)";
			// pass the SQL statement to prepared statement
			preparedStatement = connection.prepareStatement(sql);
			// add values from delivery
			preparedStatement.setInt(1, reservation.getTableId());
			preparedStatement.setInt(2, reservation.getCustomerId());
			preparedStatement.setInt(3, reservation.getOrderId());
			preparedStatement.setInt(4, reservation.getReceptionId());
			preparedStatement.setTimestamp(5, Timestamp.valueOf(reservation.getTime()));
			// execute query
			preparedStatement.execute();
			// Confirmation message
			System.out.println("[DONE] Reservation ordered successfully!");
			// return true
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public String getReservationTime(int resid) {
		sql = "SELECT * FROM "+table+" WHERE resid = " + resid;
		String orders = "";
		try {
			resultSet = statement.executeQuery(sql);
			if(resultSet.next()) {
				return resultSet.getTimestamp(6).toString();		
			}
			return orders;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public int getReservationId(int oid) {
		sql = "SELECT resid FROM "+table+" WHERE oid = " + oid;
		try {
			resultSet = statement.executeQuery(sql);
			if(resultSet.next()) {
				return resultSet.getInt(1);	
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}
	
	public boolean cancelReservation(int id) {
		// add try catch block		
		try {
			// create SQL statement
			sql = "DELETE FROM " + table + " WHERE resid = ?";
			// pass the SQL statement to prepared statement
			preparedStatement = connection.prepareStatement(sql);
			// add values from delivery
			preparedStatement.setInt(1, id);
			// execute query
			preparedStatement.execute();
			// Confirmation message
			System.out.println("[DONE] Reservation canceled successfully!");
			// return true
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
