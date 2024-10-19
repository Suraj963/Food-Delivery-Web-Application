package com.fooddelivery.daoImp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fooddelivery.dao.MenuDAO;
import com.fooddelivery.model.Menu;



public class MenuDAOImpl implements MenuDAO {
	
	private static Connection connection = null;
	private static PreparedStatement statement = null;
	private static ResultSet res = null;
	
	private final static String addMenu_Query = "insert into `menu` (`menuID`, `restaurantID`, `itemName`, `description`, `price`, `IsAvailable`) values(?, ?, ?, ?, ?, ?)";
	private final static String getMenu_Query = "select * from `menu` where `menuId` = ?";
	private final static String updateMenu_Query = "update `menu` set `itemName` = ?, `description` = ?, `price` = ?, `IsAvailable` = ?";
	private final static String deleteMenu_Query = "delete from `menu` where `menuId` = ?";
	private final static String getAllMenusByRestaurant_Query = "select * from `menu` where `restaurantID` = ?";
	
	public MenuDAOImpl() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/fooddeliveryapp", "root", "root");
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	
	@Override
	public void addMenu(Menu menu) {
		try {
			statement = connection.prepareStatement(addMenu_Query);
			
			statement.setInt(1, menu.getMenuID());
			statement.setInt(2, menu.getRestaurantID());
			statement.setString(3, menu.getItemName());
			statement.setString(4, menu.getDescription());
			statement.setDouble(5, menu.getPrice());
			statement.setBoolean(6, menu.getIsAvailable());
			
			int i = statement.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	@Override
	public Menu getMenu(int menuId) {
		
		try {
			statement = connection.prepareStatement(getMenu_Query);
			
			statement.setInt(1, menuId);
			res = statement.executeQuery();
			
			if(res.next()) {
				
				int menuID = res.getInt("menuId");
				int restaurantID = res.getInt("restaurantID");
				String itemName = res.getString("itemName");
				String description = res.getString("description");
				double price = res.getDouble("price");
				boolean IsAvailable = res.getBoolean("IsAvailable");
				
				return new Menu(menuID, restaurantID, itemName, description, price, IsAvailable);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	
	
	
	@Override
	public void updateMenu(Menu menu) {
		
		try {
			statement = connection.prepareStatement(updateMenu_Query);
			
			statement.setString(1, menu.getItemName());
			statement.setString(2, menu.getDescription());
			statement.setDouble(2, menu.getPrice());
			statement.setBoolean(2, menu.getIsAvailable());
			
			int i = statement.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	

	@Override
	public void deleteMenu(int menuId) {
		
		try {
			statement = connection.prepareStatement(deleteMenu_Query);
			
			statement.setInt(1, menuId);
			
			int i = statement.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	
	
	@Override
	public List<Menu> getAllMenusByRestaurant(int restaurantId) {
		
		ArrayList<Menu> menu = new ArrayList<Menu>();
		
		try {
			statement = connection.prepareStatement(getAllMenusByRestaurant_Query);
			
			statement.setInt(1, restaurantId);
			res = statement.executeQuery();;
			
			while(res.next()) {
				int menuID = res.getInt("menuID");
				int restaurantID = res.getInt("restaurantID");
				String itemName = res.getString("itemName");
				String description = res.getString("description");
				double price = res.getDouble("price");
				boolean IsAvailable = res.getBoolean("IsAvailable");
				
				Menu m = new Menu(menuID, restaurantID, itemName, description, price, IsAvailable);
				
				menu.add(m);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		
		return menu;
	}

	
	
	
	
	
	
	
	
	
	
}
