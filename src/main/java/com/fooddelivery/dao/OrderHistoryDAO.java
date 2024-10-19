package com.fooddelivery.dao;

import java.util.List;

import com.fooddelivery.model.OrderHistory;

public interface OrderHistoryDAO {

	void addOrderHistory(OrderHistory orderHistory);
	OrderHistory getOrderHistory(int orderHistoryID);
	void updateOrderHistory(OrderHistory orderHistory);
	void deleteOrderHistory(int orderHistoryID);
	List<OrderHistory> getOrderHistoriesByUser(int userId);
}
