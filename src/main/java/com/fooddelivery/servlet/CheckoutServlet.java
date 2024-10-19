package com.fooddelivery.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fooddelivery.dao.OrderDAO;
import com.fooddelivery.daoImp.OrderDAOImpl;
import com.fooddelivery.model.Cart;
import com.fooddelivery.model.CartItem;
import com.fooddelivery.model.Order;
import com.fooddelivery.model.User;

@WebServlet("/checkout")
public class CheckoutServlet extends HttpServlet{

	private OrderDAO orderDAO;
	
	@Override
	public void init() throws ServletException {
		orderDAO = new OrderDAOImpl();
	}
	
	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		Cart cart = (Cart) session.getAttribute("cart");
		User user = (User) session.getAttribute("loggedInUser");
		if (cart != null && user != null && !cart.getItems().isEmpty()) {
			// Extract checkout form data 
			String paymentMethod = request.getParameter("paymentMethod");
			
			
			
			java.util.Date utilDate = new java.util.Date();

			// Create and populate the order object
			Order order = new Order();
			order.setOrderID(user.getUserID());
			System.out.println(session.getAttribute("resturantId"));
			order.setRestaurantID((int) session.getAttribute("resturantId"));
			order.setOrderDate(new java.sql.Date(utilDate.getTime()));
			order.setPaymentMethod(paymentMethod);
			order.setStatus("Pending");
			
			
			double totalAmount = 0;
			for (CartItem item : cart.getItems().values()) {
				
				totalAmount += item.getPrice() * item.getQuantity();
			
			} 
			order.setTotalAmount(totalAmount);
			
			// Save the order to the database
			orderDAO.addOrder(order);
			
			
			// Clear the cart and redirect to the order confirmation page
			session.removeAttribute("cart");
			session.setAttribute("order", order);
			response.sendRedirect("order_confirmation.jsp");
		
		} else {
			response.sendRedirect("cart.jsp"); // Redirect to cart if it's empty or
		}
	}
	
	
	
	
	
}
