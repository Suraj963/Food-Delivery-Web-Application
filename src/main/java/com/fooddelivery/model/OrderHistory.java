package com.fooddelivery.model;

import java.util.Date;

public class OrderHistory {

	
	private int orderHistoryID;
	private int userID;
	private int orderID;
	private Date orderDate;
	private double totalAmount;
	private String status;
	
	
	
	public OrderHistory() {}



	public OrderHistory(int orderHistoryID, int userID, int orderID, Date orderDate, double totalAmount, String status) {
		super();
		this.orderHistoryID = orderHistoryID;
		this.userID = userID;
		this.orderID = orderID;
		this.orderDate = orderDate;
		this.totalAmount = totalAmount;
		this.status = status;
	}



	public int getOrderHistoryID() {
		return orderHistoryID;
	}



	public void setOrderHistoryID(int orderHistoryID) {
		this.orderHistoryID = orderHistoryID;
	}



	public int getUserID() {
		return userID;
	}



	public void setUserID(int userID) {
		this.userID = userID;
	}



	public int getOrderID() {
		return orderID;
	}



	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}



	public Date getOrderDate() {
		return orderDate;
	}



	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}



	public double getTotalAmount() {
		return totalAmount;
	}



	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}



	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}



	@Override
	public String toString() {
		return "OrderHistory [orderHistoryID=" + orderHistoryID + ", userID=" + userID + ", orderID=" + orderID
				+ ", orderDate=" + orderDate + ", totalAmount=" + totalAmount + ", status=" + status + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
