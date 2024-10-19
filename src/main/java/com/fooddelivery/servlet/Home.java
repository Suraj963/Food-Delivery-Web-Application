package com.fooddelivery.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fooddelivery.daoImp.RestaurantDAOImpl;
import com.fooddelivery.daoImp.UserDAOImpl;
import com.fooddelivery.model.Restaurant;
import com.fooddelivery.model.User;


//@WebServlet("/home")
//public class Home extends HttpServlet {
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//    
//            RestaurantDAOImpl obj = new RestaurantDAOImpl();
//
//            List<Restaurant> restaurants = obj.getAllRestaurant();
//
//            req.setAttribute("restaurantList", restaurants);
//
//            RequestDispatcher rd = req.getRequestDispatcher("home.jsp");
//            rd.include(req, resp);
//        
//    }
//}

@WebServlet("/home")
public class Home extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Servlet doGet method is executed");
        
        
        RestaurantDAOImpl obj = new RestaurantDAOImpl();
        List<Restaurant> restaurants = obj.getAllRestaurant();

//        System.out.println("Number of restaurants: " + restaurants.size());
//
//        for (Restaurant restaurant : restaurants) {
//            System.out.println(restaurant);
//        }

        req.setAttribute("restaurantList", restaurants);

        RequestDispatcher rd = req.getRequestDispatcher("home.jsp");
        rd.forward(req, resp);
    }
    
    


    
    
    
    
}