package com.alimama.data_util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.alimama.users.Board;

public class BoardDataUtil {
	private Connection connection;
	private Statement statement;
	private PreparedStatement preparedStatement;
	private ResultSet resultSet;
	private String DBUsername = "alimama";
	private String DBPassword = "alimama";
	private String sql;
	private String table = "board";

	public BoardDataUtil() {
		try {
			System.out.println("Connecting alimama database ...");
			// register MYSQL JDBC driver
			Class.forName("com.mysql.jdbc.Driver");
			// create a connection
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/alimamadb", DBUsername, DBPassword);
			System.out.println("[OK] Successfully connected!");
		} catch (SQLException e) {
			System.err.println("[ERROR] Failed to connect with the alimama database!");
		} catch (Exception e) {
			System.err.println("[ERROR] Failed to register mysql driver!");
		}
	}
	// get all users

	public List<Board> getAllUsers() {
		// create array to store users
		List<Board> board = new ArrayList<>();
		// SQL statement
		sql = "SELECT * FROM " + table;
		try {
			// initialize statement
			statement = connection.createStatement();
			// send SQL statement to statement
			resultSet = statement.executeQuery(sql);
			// loop through result and add to users
			while (resultSet.next()) {
				board.add(new Board(
						resultSet.getString(2),
						resultSet.getString(3),
						resultSet.getString(4),
						resultSet.getString(5),
						resultSet.getString(6),
						resultSet.getString(7)
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
		return board;
	}
	// get specific user wit id, phone or email
	public <T> Board getUser(T t) {
		// SQL statement
		sql = "SELECT * FROM " + table + " WHERE email=?";
		
		// identify parameter key type
        if (t instanceof Integer) {
        	sql = "SELECT * FROM " + table + " WHERE id=?";
        } else if (t instanceof String) {
            try {
                Integer.parseInt((String) t);
                sql = "SELECT * FROM " + table + " WHERE phone=?";
            } catch (NumberFormatException e) {
            	sql = "SELECT * FROM " + table + " WHERE email=?";
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
				return new Board(
						resultSet.getString(2),
						resultSet.getString(3),
						resultSet.getString(4),
						resultSet.getString(5),
						resultSet.getString(6),
						resultSet.getString(7)
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
	// create user
	public void createUser(Board user) {
		// SQL statement
		sql = "INSERT INTO " + table + " (firstName, lastName, phone, email, hashedPassword, title)"
				+ "VALUE (?,?,?,?,?,?)";
		try {
			// create prepare statement
			preparedStatement = connection.prepareStatement(sql);
			// sent data to prepare statement
			preparedStatement.setString(1, user.getFirstName());
			preparedStatement.setString(2, user.getLastName());
			preparedStatement.setString(3, user.getPhone());
			preparedStatement.setString(4, user.getEmail());
			preparedStatement.setString(5, user.getHashedPassword());
			preparedStatement.setString(6, user.getTitle());
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

	// update user
	public void updateUser(Board user) {
		// SQL statement
		sql = "UPDATE " + table + " SET firstName=?, lastName=?, "
		+"phone=?, email=?, hashedPassword=?, title=? WHERE email=?";
		try {
			// create prepare statement
			preparedStatement = connection.prepareStatement(sql);
			// sent data to prepare statement
			preparedStatement.setString(1, user.getFirstName());
			preparedStatement.setString(2, user.getLastName());
			preparedStatement.setString(3, user.getPhone());
			preparedStatement.setString(4, user.getEmail());
			preparedStatement.setString(5, user.getHashedPassword());
			preparedStatement.setString(6, user.getTitle());
			preparedStatement.setString(7, user.getEmail());
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

	// delete user
	public <T> void deleteUser(T t) {
		// identify parameter key for SQL statement
        if (t instanceof Integer) {
    		sql = "DELETE FROM " + table + " WHERE id=?";
        } else if (t instanceof String) {
            try {
            	Integer.parseInt((String) t);
        		sql = "DELETE FROM " + table + " WHERE phone=?";
            } catch (NumberFormatException e) {
        		sql = "DELETE FROM " + table + " WHERE email=?";
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