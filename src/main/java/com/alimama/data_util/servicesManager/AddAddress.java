package com.alimama.data_util.servicesManager;

public class AddAddress extends ServicesDataManager{
	String table = "address";
	
	public void addAddress(int cid, String address) {
		// add try catch block
		try {
			// create SQL statement
			sql = "INSERT INTO " + table + " (cid, address)"
					+ " VALUE (?,?)";
			// pass the SQL statement to prepared statement
			preparedStatement = connection.prepareStatement(sql);
			// add values from delivery
			preparedStatement.setInt(1, cid);
			preparedStatement.setString(2, address);
			// execute query
			preparedStatement.execute();
			// Confirmation message
			System.out.println("[DONE] Address add to database successfully!");
			// return true

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String getAddress(int cid) {
		try {
			// create SQL statement
			sql = "SELECT address FROM " + table + " WHERE cid = ? order by time DESC limit 1";
			// pass the SQL statement to prepared statement
			preparedStatement = connection.prepareStatement(sql);
			// add values from delivery
			preparedStatement.setInt(1, cid);
			// execute query
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				return resultSet.getString(1);
			}
			// Confirmation message
			System.out.println("[DONE] Address add to database successfully!");
			// return true

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
