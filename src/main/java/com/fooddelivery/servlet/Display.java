package com.fooddelivery.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fooddelivery.daoImp.UserDAOImpl;
import com.fooddelivery.model.User;

@WebServlet("/users")
public class Display extends HttpServlet{

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		UserDAOImpl obj = new UserDAOImpl();
		
		List<User> users = obj.getAllUsers();
		
		req.setAttribute("usersList", users);
		
		RequestDispatcher rd = req.getRequestDispatcher("users.jsp");
		rd.include(req, resp);
		
		
		
	}
	
	
	
	
}
