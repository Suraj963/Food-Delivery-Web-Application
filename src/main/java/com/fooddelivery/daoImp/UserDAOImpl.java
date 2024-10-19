package com.fooddelivery.daoImp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.fooddelivery.dao.UserDAO;
import com.fooddelivery.model.User;


public class UserDAOImpl implements UserDAO{
	
	private static Connection connection = null;
	private static PreparedStatement statement = null;
	private static ResultSet res = null;
	private static Statement stmt = null;
	
	private final static String addUser_Query = "insert into `user` (`userID`, `username`, `password`, `email`, `address`, `role`) values(?, ?, ?, ?, ?, ?)";
	private final static String getUser_Query = "select * from `user` where `userId` = ?";
	private final static String updateUser_Query = "update `user` set `username` = ?, `password` = ?, `email` = ?, `address` = ?, `role` = ?";
	private final static String deleteUser_Query = "delete from `user` where `userID` = ?";
	private final static String getAllUsers_Query = "select * from `user`";

	
	public UserDAOImpl() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/fooddeliveryapp", "root", "root");
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	@Override
	public void addUser(User user) {
		
		try {
			statement = connection.prepareStatement(addUser_Query);
			
			statement.setInt(1, user.getUserID());
			statement.setString(2, user.getUsername());
			statement.setString(3, user.getPassword());
			statement.setString(4, user.getEmail());
			statement.setString(5, user.getAddress());
			statement.setString(6, user.getRole());
			
			int i = statement.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	
	@Override
	public User getUser(int userId) {
		
		try {
			statement = connection.prepareStatement(getUser_Query);
			
			statement.setInt(1, userId);
			res = statement.executeQuery();
			
			if(res.next()) {
				
				int userID = res.getInt("userID");
				String username = res.getString("username");
				String password = res.getString("password");
				String email = res.getString("email");
				String address = res.getString("address");
				String role = res.getString("role");
				
				return new User(userID, username, password, email, address, role);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	
	
	
	@Override
	public void updateUser(User user) {
		
		try {
			statement = connection.prepareStatement(updateUser_Query);
			
			statement.setInt(1, user.getUserID());
			statement.setString(2, user.getUsername());
			statement.setString(3, user.getPassword());
			statement.setString(4, user.getEmail());
			statement.setString(5, user.getAddress());
			statement.setString(6, user.getRole());
			
			int i = statement.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	
	
	
	@Override
	public void deleteUser(int userId) {
		
		try {
			statement = connection.prepareStatement(deleteUser_Query);
			
			statement.setInt(1, userId);
			
			int i = statement.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	
	
	
	@Override
	public List<User> getAllUsers() {
		
		ArrayList<User> users = new ArrayList<User>();
		
		try {
			stmt = connection.createStatement();
			res = stmt.executeQuery(getAllUsers_Query);
			
			while(res.next()) {
				int userID = res.getInt("userID");
				String username = res.getString("username");
				String password = res.getString("password");
				String email = res.getString("email");
				String address = res.getString("address");
				String role = res.getString("role");
				
				User u = new User(userID, username, password, email, address, role);
				users.add(u);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return users;
	}




	@Override
	public User getUserByUsername(String username) {
		String getUserName = "select * from `user` where username=?";
		
		try {
			statement = connection.prepareStatement(getUserName);
			
			statement.setString(1, username);
			res = statement.executeQuery();
			
			if(res.next()) {
				
				int userID = res.getInt("userID");
				String name = res.getString("username");
				String password = res.getString("password");
				String email = res.getString("email");
				String address = res.getString("address");
				String role = res.getString("role");
				
				return new User(userID, name, password, email, address, role);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

}







































