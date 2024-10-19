package com.fooddelivery.model;

public class CartItem {

	private int itemId;
	private int resrestaurantID;
	private String name;
	private int quantity;
	private double price;
	
	
	
	public CartItem(int itemId, int resrestaurantID, String name, int quantity, double price) {
		super();
		this.itemId = itemId;
		this.resrestaurantID = resrestaurantID;
		this.name = name;
		this.quantity = quantity;
		this.price = price;
	}



	public int getItemId() {
		return itemId;
	}



	public void setItemId(int itemId) {
		this.itemId = itemId;
	}



	public int getResrestaurantID() {
		return resrestaurantID;
	}



	public void setResrestaurantID(int resrestaurantID) {
		this.resrestaurantID = resrestaurantID;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public double getPrice() {
		return price;
	}



	public void setPrice(double price) {
		this.price = price;
	}



	public int getQuantity() {
		return quantity;
	}



	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}



	@Override
	public String toString() {
		return "cartItem [itemId=" + itemId + ", resrestaurantID=" + resrestaurantID + ", name=" + name + ", price="
				+ price + ", quantity=" + quantity + "]";
	}
	
	
	
	
	
}
