package com.fooddelivery.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fooddelivery.dao.MenuDAO;
import com.fooddelivery.daoImp.MenuDAOImpl;
import com.fooddelivery.model.Menu;


@WebServlet("/menu")
public class MenuServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String restaurantId = req.getParameter("restaurantId");
		
		MenuDAOImpl obj = new MenuDAOImpl();
		
		if(restaurantId != null) {
			try {
				List<Menu> menuList = obj.getAllMenusByRestaurant(Integer.parseInt(restaurantId));
				
				req.setAttribute("menuList", menuList);
				
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		
		RequestDispatcher rd = req.getRequestDispatcher("menu.jsp");
		rd.forward(req, resp);
	}
}
