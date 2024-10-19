package com.fooddelivery.model;

public class Menu {

	private int menuID;
	private int restaurantID;
	private String itemName;
	private String description;
	private double price;
	private boolean IsAvailable;
	
	
	public Menu() {}


	public Menu(int menuID, int restaurantID, String itemName, String description, double price, boolean isAvailable) {
		super();
		this.menuID = menuID;
		this.restaurantID = restaurantID;
		this.itemName = itemName;
		this.description = description;
		this.price = price;
		IsAvailable = isAvailable;
	}


	public int getMenuID() {
		return menuID;
	}


	public void setMenuID(int menuID) {
		this.menuID = menuID;
	}


	public int getRestaurantID() {
		return restaurantID;
	}


	public void setRestaurantID(int restaurantID) {
		this.restaurantID = restaurantID;
	}


	public String getItemName() {
		return itemName;
	}


	public void setItemName(String itemName) {
		this.itemName = itemName;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public boolean getIsAvailable() {
		return IsAvailable;
	}


	public void setIsAvailable(boolean isAvailable) {
		IsAvailable = isAvailable;
	}


	@Override
	public String toString() {
		return "Menu [menuID=" + menuID + ", restaurantID=" + restaurantID + ", itemName=" + itemName + ", description="
				+ description + ", price=" + price + ", IsAvailable=" + IsAvailable + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
