package com.fooddelivery.dao;

import java.util.List;

import com.fooddelivery.model.Menu;

public interface MenuDAO {

	void addMenu(Menu menu);
	Menu getMenu(int menuId);
	void updateMenu(Menu menu);
	void deleteMenu(int menuId);
	List<Menu> getAllMenusByRestaurant(int restaurantId);
}
