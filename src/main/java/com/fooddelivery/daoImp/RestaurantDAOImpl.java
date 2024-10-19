package com.fooddelivery.daoImp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//import java.util.ArrayList;
//import java.util.List;

import com.fooddelivery.dao.RestaurantDAO;
import com.fooddelivery.model.Restaurant;

//public class RestaurantDAOImpl implements RestaurantDAO{
//
//	
////	public Connection connection = null;
////	public PreparedStatement statement = null;
////	public ResultSet res = null;
////	public Statement stmt = null;
//	
//	public String addRestaurant_Query = "insert into `restaurant` (`restaurantID`, `name`, `cuisineType`, `deliveryTime`, `address`, `adminUserID`, `rating`, `isActive`, `imagePath`)"
//														+ " values(?, ?, ?, ?, ?, ?, ?, ?, ?)";
//	public String getRestaurant_Query = "select * from `restaurant` where `restaurantId` = ?";
//	public String updateRestaurant_Query = "update `restaurantId` set `name` = ?, `cuisineType` = ?, `deliveryTime` = ?, `address` = ?, `adminUserID` = ?, `rating` = ?, `isActive` = ?, `imagePath` = ?";
//	public String deleteRestaurant_Query = "delete from `restaurant` where `restaurantId` = ?";
//	public String getAllRestaurant_Query = "select * from `Restaurant`";
//	
//	
//	
//
//	public RestaurantDAOImpl() {
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/fooddeliveryapp", "root", "root");
//			
//		} catch (ClassNotFoundException | SQLException e) {
//			e.printStackTrace();
//		}
//	}
//	
//	
//	
//	
//	@Override
//	public void addRestaurant(Restaurant restaurant) {
//		
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/fooddeliveryapp", "root", "root");
//			PreparedStatement statement = connection.prepareStatement(addRestaurant_Query);
//			
//			statement.setInt(1, restaurant.getRestaurantID());
//			statement.setString(2, restaurant.getName());
//			statement.setString(3, restaurant.getCuisineType());
//			statement.setInt(4, restaurant.getDeliveryTime());
//			statement.setString(5, restaurant.getAddress());
//			statement.setInt(6, restaurant.getAdminUserID());
//			statement.setDouble(7, restaurant.getRating());
//			statement.setBoolean(8, restaurant.getIsActive());
//			statement.setString(9, restaurant.getImagePath());
//			
//			int i = statement.executeUpdate();
//			
//		} catch (SQLException | ClassNotFoundException e) {
//			e.printStackTrace();
//		}
//		
//	}
//
//	
//	
//
//	@Override
//	public Restaurant getRestaurant(int restaurantId) {
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/fooddeliveryapp", "root", "root");
//			PreparedStatement statement = connection.prepareStatement(getRestaurant_Query);
//			
//			statement.setInt(1, restaurantId);
//			ResultSet res = statement.executeQuery();
//			
//			if(res.next()) {
//				
//				int restaurantID = res.getInt("restaurantID");
//				String name = res.getString("name");
//				String cuisineType = res.getString("cuisineType");
//				int deliveryTime = res.getInt("deliveryTime");
//				String address = res.getString("address");
//				int adminUserID = res.getInt("adminUserID");
//				double rating = res.getDouble("rating");
//				boolean isActive = res.getBoolean("isActive");
//				String imagePath = res.getString("imagePath");
//				
//				return new Restaurant(restaurantID, name, cuisineType, deliveryTime, address, adminUserID, rating, isActive, imagePath);
//			}
//			
//			
//		} catch (SQLException | ClassNotFoundException e) {
//			e.printStackTrace();
//		}
//		
//		return null;
//	}
//
//	
//	
//
//	@Override
//	public void updateRestaurant(Restaurant restaurant) {
//
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/fooddeliveryapp", "root", "root");
//			
//			PreparedStatement statement = connection.prepareStatement(updateRestaurant_Query);
//			
//			statement.setString(1, restaurant.getName());
//			statement.setString(2, restaurant.getCuisineType());
//			statement.setInt(3, restaurant.getDeliveryTime());
//			statement.setString(4, restaurant.getAddress());
//			statement.setInt(5, restaurant.getAdminUserID());
//			statement.setDouble(6, restaurant.getRating());
//			statement.setBoolean(6, restaurant.getIsActive());
//			statement.setString(7, restaurant.getImagePath());
//			
//			int i = statement.executeUpdate();
//			
//		} catch (SQLException | ClassNotFoundException e) {
//			e.printStackTrace();
//		}
//	}
//
//	
//	
//
//	@Override
//	public void deleteRestaurant(int restaurantId) {
//		
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/fooddeliveryapp", "root", "root");
//			
//			PreparedStatement statement = connection.prepareStatement(deleteRestaurant_Query);
//			
//			statement.setInt(1, restaurantId);
//			
//			int i = statement.executeUpdate();
//			
//			
//		} catch (SQLException | ClassNotFoundException e) {
//			e.printStackTrace();
//		}
//	}
//
//	
//	
//
//	@Override
//	public List<Restaurant> getAllRestaurant() {
//		
//		ArrayList<Restaurant> restaurants = new ArrayList<Restaurant>();
//		
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/fooddeliveryapp", "root", "root");
//			
//			Statement stmt = connection.createStatement();
//			ResultSet res = stmt.executeQuery(getAllRestaurant_Query);
//			
//			while(res.next()) {
//				
//				int restaurantID = res.getInt("restaurantID");
//				String name = res.getString("name");
//				String cuisineType = res.getString("cuisineType");
//				int deliveryTime = res.getInt("deliveryTime");
//				String address = res.getString("address");
//				int adminUserID = res.getInt("adminUserID");
//				double rating = res.getDouble("rating");
//				boolean isActive = res.getBoolean("isActive");
//				String imagePath = res.getString("imagePath");
//				
//				Restaurant r = new Restaurant(restaurantID, name, cuisineType, deliveryTime, address, adminUserID, rating, isActive, imagePath);
//				
//				restaurants.add(r);
//			}
//			
//		} catch (SQLException | ClassNotFoundException e) {
//			e.printStackTrace();
//		}
//		
//		return restaurants;
//	}
//
//}




import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RestaurantDAOImpl implements RestaurantDAO {
    private static final String URL = "jdbc:mysql://localhost:3306/fooddeliveryapp";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";
    private Connection connection;

    public RestaurantDAOImpl() {
        try {
            // Load JDBC driver and establish a connection
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addRestaurant(Restaurant restaurant) {
        try {
            String query = "INSERT INTO restaurant (name, cuisineType, deliveryTime, address, adminUserID, rating, isActive, imagePath) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, restaurant.getName());
                preparedStatement.setString(2, restaurant.getCuisineType());
                preparedStatement.setInt(3, restaurant.getDeliveryTime());
                preparedStatement.setString(4, restaurant.getAddress());
                preparedStatement.setInt(5, restaurant.getAdminUserID());
                preparedStatement.setDouble(6, restaurant.getRating());
                preparedStatement.setBoolean(7, restaurant.getIsActive());
                preparedStatement.setString(8, restaurant.getImagePath());

                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Restaurant getRestaurant(int restaurantID) {
        Restaurant restaurant = null;
        try {
            String query = "SELECT * FROM restaurant WHERE restaurantID = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, restaurantID);

                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    restaurant = mapResultSetToRestaurant(resultSet);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return restaurant;
    }

    @Override
    public List<Restaurant> getAllRestaurant() {
        List<Restaurant> restaurants = new ArrayList<>();
        try {
            String query = "SELECT * FROM restaurant";
            try (Statement statement = connection.createStatement()) {
                ResultSet resultSet = statement.executeQuery(query);
                while (resultSet.next()) {
                    Restaurant restaurant = mapResultSetToRestaurant(resultSet);
                    restaurants.add(restaurant);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return restaurants;
    }

    
    @Override
    public void updateRestaurant(Restaurant restaurant) {
        try {
            String query = "UPDATE restaurant SET name=?, cuisineType=?, deliveryTime=?, address=?, adminUserID=?, rating=?, isActive=?, imagePath=? WHERE restaurantID=?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, restaurant.getName());
                preparedStatement.setString(2, restaurant.getCuisineType());
                preparedStatement.setInt(3, restaurant.getDeliveryTime());
                preparedStatement.setString(4, restaurant.getAddress());
                preparedStatement.setInt(5, restaurant.getAdminUserID());
                preparedStatement.setDouble(6, restaurant.getRating());
                preparedStatement.setBoolean(7, restaurant.getIsActive());
                preparedStatement.setString(8, restaurant.getImagePath());
                preparedStatement.setInt(9, restaurant.getRestaurantID());

                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteRestaurant(int restaurantID) {
        try {
            String query = "DELETE FROM restaurant WHERE restaurantID=?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, restaurantID);

                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }




    private Restaurant mapResultSetToRestaurant(ResultSet resultSet) throws SQLException {
        Restaurant restaurant = new Restaurant();
        restaurant.setRestaurantID(resultSet.getInt("restaurantID"));
        restaurant.setName(resultSet.getString("name"));
        restaurant.setCuisineType(resultSet.getString("cuisineType"));
        restaurant.setDeliveryTime(resultSet.getInt("deliveryTime"));
        restaurant.setAddress(resultSet.getString("address"));
        restaurant.setAdminUserID(resultSet.getInt("adminUserID"));
        restaurant.setRating(resultSet.getDouble("rating"));
        restaurant.setIsActive(resultSet.getBoolean("isActive"));
        restaurant.setImagePath(resultSet.getString("imagePath"));
        return restaurant;
    }
}






























