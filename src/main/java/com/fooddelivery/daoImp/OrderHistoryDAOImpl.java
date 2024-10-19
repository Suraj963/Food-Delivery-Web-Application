package com.fooddelivery.daoImp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fooddelivery.dao.OrderHistoryDAO;
import com.fooddelivery.model.OrderHistory;

public class OrderHistoryDAOImpl implements OrderHistoryDAO {

	
	private static Connection connection = null;
	private static PreparedStatement statement = null;
	private static ResultSet res = null;
	
	
	
	 private final static String addOrderHistory_Query = "INSERT INTO `orderhistory` (`orderHistoryID`, `userID`, `orderID`, `orderDate`, `totalAmount`, `status`) VALUES (?, ?, ?, ?, ?, ?)";
	 private final static String getOrderHistory_Query = "SELECT * FROM `orderhistory` WHERE `orderHistoryID` = ?";
	 private final static String updateOrderHistory_Query = "UPDATE `orderhistory` SET `orderDate` = ?, `totalAmount` = ?, `status` = ? WHERE `orderHistoryID` = ?";
	 private final static String deleteOrderHistory_Query = "DELETE FROM `orderhistory` WHERE `orderHistoryID` = ?";
	 private final static String getOrderHistoriesByUser_Query = "SELECT * FROM `orderhistory` WHERE `userID` = ?";

	
	
	
	public OrderHistoryDAOImpl() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/fooddeliveryapp", "root", "root");
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
	@Override
	public void addOrderHistory(OrderHistory orderHistory) {
		try {
            // Prepare the insert query
            statement = connection.prepareStatement(addOrderHistory_Query);
            java.util.Date utilDate = new java.util.Date();
            

            // Set the parameters for the insert query
            statement.setInt(1, orderHistory.getOrderHistoryID());
            statement.setInt(2, orderHistory.getUserID());
            statement.setInt(3, orderHistory.getOrderID());
            statement.setDate(4, new java.sql.Date(utilDate.getTime()));
            statement.setDouble(5, orderHistory.getTotalAmount());
            statement.setString(6, orderHistory.getStatus());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
		
	}

	@Override
	public OrderHistory getOrderHistory(int orderHistoryID) {
		try {
		    statement = connection.prepareStatement(getOrderHistory_Query);

		    statement.setInt(1, orderHistoryID);
		    res = statement.executeQuery();

		    if (res.next()) {
		        int orderHistoryId = res.getInt("orderHistoryID");
		        int userID = res.getInt("userID");
		        int orderID = res.getInt("orderID");
		        Date orderDate = res.getDate("orderDate");
		        double totalAmount = res.getDouble("totalAmount");
		        String status = res.getString("status");

		        return new OrderHistory(orderHistoryId, userID, orderID, orderDate, totalAmount, status);
		    }
		} catch (SQLException e) {
		    e.printStackTrace();
		}
		return null;
	}

	
	
	
	@Override
	public void updateOrderHistory(OrderHistory orderHistory) {
		 try {
	            // Prepare the update query
	            statement = connection.prepareStatement(updateOrderHistory_Query);

	            // Set the parameters for the update query
	            statement.setDate(1, new java.sql.Date(orderHistory.getOrderDate().getTime()));
	            statement.setDouble(2, orderHistory.getTotalAmount());
	            statement.setString(3, orderHistory.getStatus());

	            // Execute the update query
	            statement.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
		
	}

	
	
	
	@Override
	public void deleteOrderHistory(int orderHistoryID) {
		try {
            // Prepare the delete query
            statement = connection.prepareStatement(deleteOrderHistory_Query);

            // Set the parameter for the delete query
            statement.setInt(1, orderHistoryID);

            // Execute the delete query
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
		
	}

	
	
	
	@Override
	public List<OrderHistory> getOrderHistoriesByUser(int userId) {
		 ArrayList<OrderHistory> orderHistories = new ArrayList<OrderHistory>();

		    try {
		        statement = connection.prepareStatement(getOrderHistoriesByUser_Query);

		        statement.setInt(1, userId);
		        res = statement.executeQuery();

		        while (res.next()) {
		            int orderHistoryID = res.getInt("orderHistoryID");
		            int userID = res.getInt("userID");
		            int orderID = res.getInt("orderID");
		            Date orderDate = res.getDate("orderDate");
		            double totalAmount = res.getDouble("totalAmount");
		            String status = res.getString("status");

		            OrderHistory orderHistory = new OrderHistory(orderHistoryID, userID, orderID, orderDate, totalAmount, status);
		            orderHistories.add(orderHistory);
		        }

		    } catch (SQLException e) {
		        e.printStackTrace();
		    }

		    return orderHistories;
	}

}





















