package com.fooddelivery.dao;

import java.util.List;

import com.fooddelivery.model.OrderItem;

public interface OrderItemDAO {

	void addOrderItem(OrderItem orderItem);
	OrderItem getOrderItem(int orderItemId);
	void updateOrderItem(OrderItem orderItem);
	void deleteOrderItem(int orderItemId);
	List<OrderItem> getOrderItemsByOrder(int orderId);
}
