package com.alimama.data_util;

import com.alimama.users.Customer;
import com.alimama.users.User;
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
	private String DBUsername = "alimamaCustomer";
	private String DBPassword = "alimamaCustomer";
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
		// SQL statement
		sql = "SELECT * FROM customer";
		try {
			// initialize statement
			statement = connection.createStatement();
			// send SQL statement to statement
			resultSet = statement.executeQuery(sql);
			// loop through result and add to users
			while (resultSet.next()) {
				users.add(new Customer(
						resultSet.getString(2),
						resultSet.getString(3),
						resultSet.getString(4),
						resultSet.getString(5),
						resultSet.getString(6)
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
	public <T> User getUser(T t) {
		// SQL statement
		sql = "SELECT * FROM customer WHERE email=?";
		
		// identify parameter key type
        if (t instanceof Integer) {
        	sql = "SELECT * FROM customer WHERE id=?";
        } else if (t instanceof String) {
            try {
                Integer.parseInt((String) t);
                sql = "SELECT * FROM customer WHERE phone=?";
            } catch (NumberFormatException e) {
            	sql = "SELECT * FROM customer WHERE email=?";
            }
        }
		
		try {
			// create prepare statement
			preparedStatement = connection.prepareStatement(sql);
			// pass the request key to prepare statement
	        if (t instanceof Integer) {
	        	preparedStatement.setInt(1, (Integer) t);
	        } else if (t instanceof String) {
	            try {
	                Integer.parseInt((String) t);
	                preparedStatement.setString(1, (String) t);;
	            } catch (NumberFormatException e) {
	            	preparedStatement.setString(1, (String) t);;
	            }
	        }
			// get result from database
			resultSet = preparedStatement.executeQuery();
			// create User object from the data
			if (resultSet.next()) {
				return new Customer(
						resultSet.getString(2),
						resultSet.getString(3),
						resultSet.getString(4),
						resultSet.getString(5),
						resultSet.getString(6)
						);
			}

		} catch (SQLException e) {
			System.err.println("[ERROR] Failed to get user data!");
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
		// SQL statement
		sql = "INSERT INTO customer (firstName, lastName, email, phone, hashedPassword)"
				+ "VALUE (?,?,?,?,?)";
		try {
			// create prepare statement
			preparedStatement = connection.prepareStatement(sql);
			// sent data to prepare statement
			preparedStatement.setString(1, user.getFirstName());
			preparedStatement.setString(2, user.getLastName());
			preparedStatement.setString(3, user.getEmail());
			preparedStatement.setString(4, user.getPhone());
			preparedStatement.setString(5, user.getHashedPassword());
			// execute prepare statement
			preparedStatement.execute();
			System.out.println("[OK] " + user.getFirstName() + " creates account successfully!");
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
		// SQL statement
		sql = "UPDATE customer SET firstName=?, lastName=?, "
		+"email=?, phone=?, hashedPassword=? WHERE email=?";
		try {
			// create prepare statement
			preparedStatement = connection.prepareStatement(sql);
			// sent data to prepare statement
			preparedStatement.setString(1, user.getFirstName());
			preparedStatement.setString(2, user.getLastName());
			preparedStatement.setString(3, user.getEmail());
			preparedStatement.setString(4, user.getPhone());
			preparedStatement.setString(5, user.getHashedPassword());
			preparedStatement.setString(6, user.getEmail());
			// execute prepare statement
			preparedStatement.execute();
			System.out.println("[OK] " + user.getFirstName() + " update account successfully!");
		} catch (SQLException e) {
			System.err.println("[ERROR] Failed to update a user!");
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
	public <T> void deleteUser(T t) {
		// identify parameter key for SQL statement
        if (t instanceof Integer) {
    		sql = "DELETE FROM customer WHERE id=?";
        } else if (t instanceof String) {
            try {
            	Integer.parseInt((String) t);
        		sql = "DELETE FROM customer WHERE phone=?";
            } catch (NumberFormatException e) {
        		sql = "DELETE FROM customer WHERE email=?";
            }
        }

		try {
			// create prepare statement
			preparedStatement = connection.prepareStatement(sql);
			// pass the request key to prepare statement
	        if (t instanceof Integer) {
	        	preparedStatement.setInt(1, (Integer) t);
	        } else if (t instanceof String) {
	            try {
	                Integer.parseInt((String) t);
	                preparedStatement.setString(1, (String) t);;
	            } catch (NumberFormatException e) {
	            	preparedStatement.setString(1, (String) t);;
	            } finally {
	            	System.out.println(sql);
	            }
	        }
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