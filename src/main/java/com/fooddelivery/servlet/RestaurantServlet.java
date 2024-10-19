package com.fooddelivery.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fooddelivery.model.Restaurant;
import com.fooddelivery.daoImp.RestaurantDAOImpl;



@WebServlet("/restaurant")
public class RestaurantServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    	RestaurantDAOImpl rest = new RestaurantDAOImpl();
    	
    	List<Restaurant> allRestaurant = rest.getAllRestaurant();
    	
    	for(Restaurant r : allRestaurant) {
    		System.out.println(r);
    	}
    	
    }
    }