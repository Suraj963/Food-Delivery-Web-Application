package com.fooddelivery.dao;

import java.util.List;

import com.fooddelivery.model.Order;

public interface OrderDAO {

	void addOrder(Order order);
	Order getOrder(int orderId);
	void updateOrder(Order order);
	void deleteOrder(int orderId);
	List<Order> getAllOrdersByUser(int userId);
}
