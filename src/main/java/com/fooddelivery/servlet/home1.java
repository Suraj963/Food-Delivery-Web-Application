package com.fooddelivery.servlet;

import java.util.List;

import com.fooddelivery.daoImp.RestaurantDAOImpl;
import com.fooddelivery.model.Restaurant;

public class home1 {

	public static void main(String[] args) {
		
		RestaurantDAOImpl rest = new RestaurantDAOImpl();
    	
    	List<Restaurant> allRestaurant = rest.getAllRestaurant();
    	
    	for(Restaurant r : allRestaurant) {
    		System.out.println(r.getName());
    	}
	}

}
