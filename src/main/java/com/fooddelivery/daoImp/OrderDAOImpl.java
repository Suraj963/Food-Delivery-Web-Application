package com.fooddelivery.daoImp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fooddelivery.dao.OrderDAO;
import com.fooddelivery.model.Order;




public class OrderDAOImpl implements OrderDAO {
	
	private static Connection connection = null;
	private static PreparedStatement statement = null;
	private static ResultSet res = null;
	
	
	private final static String addOrder_Query = "INSERT INTO `ordertable` (`orderID`, `userID`, `restaurantID`, `orderDate`, `totalAmount`, `status`, `paymentMethod`) VALUES (?, ?, ?, ?, ?, ?, ?)";
	private final static String getOrder_Query = "select * from `ordertable` where `orderId` = ?";
	private final static String updateOrder_Query = "update `ordertable` set `orderDate` = ?, `totalAmount` = ?, `status` = ?, `paymentMethod` = ?";
	private final static String deleteOrder_Query = "delete from `ordertable` where `orderId` = ?";
	private final static String getAllOrdersByUser_Query = "select * from `ordertable` where `userId` = ?";
	
	

	public OrderDAOImpl() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/fooddeliveryapp", "root", "root");
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	


	@Override
	public void addOrder(Order order) {
		try {
			statement = connection.prepareStatement(addOrder_Query);
			
			statement.setInt(1, order.getOrderID());
	        statement.setInt(2, order.getUserID());
	        statement.setInt(3, order.getRestaurantID());
	        statement.setDate(4, (java.sql.Date) order.getOrderDate());
	        statement.setDouble(5, order.getTotalAmount());
	        statement.setString(6, order.getStatus());
	        statement.setString(7, order.getPaymentMethod());
			
			int i = statement.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
	

	@Override
	public Order getOrder(int orderId) {
		
		try {
			statement = connection.prepareStatement(getOrder_Query);
			
			statement.setInt(1, orderId);
			res = statement.executeQuery();
			
			if(res.next()) {
				
				int orderID = res.getInt("orderID");
				int userID = res.getInt("userID");
				int restaurantID = res.getInt("restaurantID");
				Date orderDate = res.getDate("orderDate");
				double totalAmount = res.getDouble("totalAmount");
				String status = res.getString("status");
				String paymentMethod = res.getString("paymentMethod");
				
				return new Order(orderID, userID, restaurantID, orderDate, totalAmount, status, paymentMethod);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	
	

	@Override
	public void updateOrder(Order order) {
		
		try {
			statement = connection.prepareStatement(updateOrder_Query);
			
			statement.setDate(1, (java.sql.Date) order.getOrderDate());
			statement.setDouble(2, order.getTotalAmount());
			statement.setString(3, order.getStatus());
			statement.setString(4, order.getPaymentMethod());
			
			int i = statement.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}

	

	@Override
	public void deleteOrder(int orderId) {
		
		try {
			statement = connection.prepareStatement(deleteOrder_Query);
			
			statement.setInt(1, orderId);
			
			int i = statement.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
	

	@Override
	public List<Order> getAllOrdersByUser(int userId) {
		
		ArrayList<Order> orders = new ArrayList<Order>();
		
		try {
			statement = connection.prepareStatement(getAllOrdersByUser_Query);
			
			statement.setInt(1, userId);
			res = statement.executeQuery();
			
			while(res.next()) {
				int orderID = res.getInt("orderID");
				int userID = res.getInt("userID");
				int restaurantID = res.getInt("restaurantID");
				Date orderDate = res.getDate("orderDate");
				double totalAmount = res.getDouble("totalAmount");
				String status = res.getString("status");
				String paymentMethod = res.getString("paymentMethod");
				
				Order o = new Order(orderID, userID, restaurantID, orderDate, totalAmount, status, paymentMethod);
				
				orders.add(o);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return orders;
	}

}



















