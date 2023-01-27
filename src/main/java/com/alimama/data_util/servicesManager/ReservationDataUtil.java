package com.alimama.data_util.servicesManager;


import com.alimama.services.Reservation;

public class ReservationDataUtil extends ServicesDataManager{
	String table = "reservation";
	public boolean orderReservation(Reservation reservation) {
		// add try catch block		
		try {
			// create SQL statement
			sql = "INSERT INTO " + table
					+ " (tid, cid, oid, recid) "
					+ "value(?,?,?,?)";
			// pass the SQL statement to prepared statement
			preparedStatement = connection.prepareStatement(sql);
			// add values from delivery
			preparedStatement.setInt(1, reservation.getTableId());
			preparedStatement.setInt(2, reservation.getCustomerId());
			preparedStatement.setInt(3, reservation.getOrderId());
			preparedStatement.setInt(4, reservation.getReceptionId());
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
