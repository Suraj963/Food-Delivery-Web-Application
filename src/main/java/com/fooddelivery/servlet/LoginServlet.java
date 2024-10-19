package com.fooddelivery.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fooddelivery.dao.UserDAO;
import com.fooddelivery.daoImp.UserDAOImpl;
import com.fooddelivery.model.User;

@WebServlet("/login")
public class LoginServlet extends HttpServlet{

	private UserDAO userDAO;
	
	@Override
	public void init(){
		userDAO = new UserDAOImpl();
	}
	

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("username");
		String password = request.getParameter("password"); 
		
		User user = userDAO.getUserByUsername(username);
		
		if (user != null && user.getPassword().equals(password)) { 
		HttpSession session = request.getSession(); 
		session.setAttribute("loggedInUser", user); 
		response.sendRedirect("home");
		
		}else {
		request.setAttribute("errorMessage", "Invalid username or password"); 
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}
}


}


































