package com.meta_restaurant.data_util;

import com.meta_restaurant.users.Customer;
import com.meta_restaurant.users.User;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CustomerDataUtil implements UserDataUtil {

	private Connection connection;
	private Statement statement;
	private PreparedStatement preparedStatement;
	private ResultSet resultSet;
	private String DBUsername = "metaCustomer";
	private String DBPassword = "metaCustomer";
	private String sql;
	
	public CustomerDataUtil() {
		try {
			System.out.println("Connecting meta database ...");
			// register MYSQL JDBC driver
			Class.forName(DBRegister);
			// create a connection
			connection = DriverManager.getConnection(DBHost, DBUsername, DBPassword);
			System.out.println("[OK] Successfully connected!");
		} catch (SQLException e) {
			System.err.println("[ERROR] Failed to connect with the meta database!");
		} catch (Exception e) {
			System.err.println("[ERROR] Failed to register mysql driver!");
		}
	}

	@Override
	public List<User> getAllUsers() {
		// create array to store users
		List<User> users = new ArrayList<>();
		// write SQL statement
		sql = "SELECT * FROM customer";
		try {
			// initialize statement
			statement = connection.createStatement();
			// send SQL statement to statement
			resultSet = statement.executeQuery(sql);
			// loop through result and add to users
			while (resultSet.next()) {	
				users.add(new Customer(
						resultSet.getInt(1),
						resultSet.getString(2),
						resultSet.getString(3),
						resultSet.getString(4),
						resultSet.getString(5)		
						));
			}
		} catch (SQLException e) {
			System.err.println("[ERROR] Failed to get all users data!");
		} finally {
			try {
				// close all connections
				connection.close();
				statement.close();
				resultSet.close();
			} catch(Exception e) {
				System.out.println("[ERROR] Failed to close connections!");
			}
		}
		return users;
	}
	
	@Override
	public User getUser(String id) {
		// write SQL statement
		sql = "SELECT * FROM customer WHERE id=?";
		try {
			// create prepare statement
			preparedStatement = connection.prepareStatement(sql);
			// pass id to prepare statement
			preparedStatement.setInt(1, Integer.parseInt(id));
			// get result from database
			resultSet = preparedStatement.executeQuery();
			// create User object from the data
			if (resultSet.next()) {
				return new Customer(
						resultSet.getInt(1),
						resultSet.getString(2),
						resultSet.getString(3),
						resultSet.getString(4),
						resultSet.getString(5));
			}

		} catch (SQLException e) {
			System.err.println("[ERROR] Failed to get " + id + "'s data!");
		} finally {
			try {
				// close all connections
				connection.close();
				preparedStatement.close();
				resultSet.close();
			} catch(Exception e) {
				System.out.println("[ERROR] Failed to close connections!");
			}
		}
		return null;
	}

	@Override
	public void createUser(User user) {
		// write SQL statement
		
		try {
			// create prepare statement
			sql = "INSERT INTO customer (firstName, lastName, email, phone)"
					+ "VALUE (?,?,?,?)";
			preparedStatement = connection.prepareStatement(sql);
			// sent data to prepare statement
			preparedStatement.setString(1, user.getFistName());
			preparedStatement.setString(2, user.getLastName());
			preparedStatement.setString(3, user.getEmail());
			preparedStatement.setString(4, user.getPhone());
			// execute prepare statement
			preparedStatement.execute();
			System.out.println("[OK] " + user.getFistName() + " creates account successfully!");
		} catch (SQLException e) {
			System.err.println("[ERROR] Failed to create a user!");
			e.printStackTrace();
		} finally {
			try {
				// close all connections
				connection.close();
				preparedStatement.close();
			} catch(Exception e) {
				System.out.println("[ERROR] Failed to close connections!");
			}
		}
	}

	@Override
	public void updateUser(User user) {
		// write SQL statement
		try {
			// create prepare statement
			sql = "UPDATE customer SET firstName=?, lastName=?,"
			+"email=?, phone=? WHERE id=?;";
			preparedStatement = connection.prepareStatement(sql);
			// sent data to prepare statement
			preparedStatement.setString(1, user.getFistName());
			preparedStatement.setString(2, user.getLastName());
			preparedStatement.setString(3, user.getEmail());
			preparedStatement.setString(4, user.getPhone());
			preparedStatement.setInt(5, user.getId());
			// execute prepare statement
			preparedStatement.execute();
			System.out.println("[OK] " + user.getFistName() + " update account successfully!");
		} catch (SQLException e) {
			System.err.println("[ERROR] Failed to update a user!");
		} finally {
			try {
				// close all connections
				connection.close();
				preparedStatement.close();
			} catch(Exception e) {
				System.out.println("[ERROR] Failed to close connections!");
			}
		}
		
	}

	@Override
	public void deleteUser(String id) {
		// write SQL statement
		sql = "DELETE FROM customer WHERE id=?";
		try {
			// create prepare statement
			preparedStatement = connection.prepareStatement(sql);
			// send id to prepare statement
			preparedStatement.setInt(1, Integer.parseInt(id));
			// execute prepare statement
			preparedStatement.execute();
			System.out.println("[OK] user deleted successfully!");
		} catch (SQLException e) {
			System.err.println("[ERROR] Failed to delete user!");
		} finally {
			try {
				// close all connections
				connection.close();
				preparedStatement.close();
			} catch(Exception e) {
				System.out.println("[ERROR] Failed to close connections!");
			}
		}
		
	}

}