package com.fooddelivery.daoImp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fooddelivery.dao.OrderItemDAO;
import com.fooddelivery.model.OrderItem;


public class OrderItemDAOImpl implements OrderItemDAO {
	
	private static Connection connection = null;
	private static PreparedStatement statement = null;
	private static ResultSet res = null;

	
	private final static String addOrderItem_Query = "INSERT INTO `orderitem` (`orderItemID`, `orderID`, `menuID`, `quantity`, `itemTotal`) VALUES (?, ?, ?, ?, ?)";
	private final static String getOrderItem_Query = "select * from `orderitem` where `orderItemID` = ?";
	private final static String updateOrderItem_Query = "update `orderitem` set `quantity` = ?, `itemTotal` = ?";
	private final static String deleteOrderItem_Query = "delete from `orderitem` where `orderItemID` = ?";
	private final static String getOrderItemsByOrder_Query = "select * from `orderitem` where `orderId` = ?";

	
	public OrderItemDAOImpl() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/fooddeliveryapp", "root", "root");
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
	@Override
	public void addOrderItem(OrderItem orderItem) {
		
		try {
			statement = connection.prepareStatement(addOrderItem_Query);
			
			statement.setInt(1, orderItem.getOrderItemID());
		    statement.setInt(2, orderItem.getOrderID()); 
		    statement.setInt(3, orderItem.getMenuID());  
		    statement.setInt(4, orderItem.getQuantity());
		    statement.setDouble(5, orderItem.getItemTotal());
			
			int i = statement.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	
	
	
	@Override
	public OrderItem getOrderItem(int orderItemId) {
		
		try {
			statement = connection.prepareStatement(getOrderItem_Query);
			
			statement.setInt(1, orderItemId);
			res = statement.executeQuery();
			
			if(res.next()) {
				
				int orderItemID = res.getInt("orderItemID");
				int orderID = res.getInt("orderID");
				int menuID = res.getInt("menuID");
				int quantity = res.getInt("quantity");
				double itemTotal = res.getDouble("itemTotal");
				
				return new OrderItem(orderItemID, orderID, menuID, quantity, itemTotal);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	
	

	@Override
	public void updateOrderItem(OrderItem orderItem) {
		
		try {
			statement = connection.prepareStatement(updateOrderItem_Query);
			
			statement.setInt(1, orderItem.getQuantity());
			statement.setDouble(2, orderItem.getItemTotal());
			
			int i = statement.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	
	
	
	@Override
	public void deleteOrderItem(int orderItemId) {
		
		try {
			statement = connection.prepareStatement(deleteOrderItem_Query);
			
			statement.setInt(1, orderItemId);
			
			int i = statement.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	
	
	@Override
	public List<OrderItem> getOrderItemsByOrder(int orderId) {
		
		ArrayList<OrderItem> orderitems = new ArrayList<OrderItem>();
		
		try {
			statement = connection.prepareStatement(getOrderItemsByOrder_Query);
			
			statement.setInt(1, orderId);
			res = statement.executeQuery();
			
			while(res.next()) {
				int orderItemID = res.getInt("orderItemID");
				int orderID = res.getInt("orderID");
				int menuID = res.getInt("menuID");
				int quantity = res.getInt("quantity");
				double itemTotal = res.getDouble("itemTotal");
				
				OrderItem o = new OrderItem(orderItemID, orderID, menuID, quantity, itemTotal);
				
				orderitems.add(o);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return orderitems;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
