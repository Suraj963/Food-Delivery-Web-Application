package com.fooddelivery.dao;

import java.util.List;

import com.fooddelivery.model.User;

public interface UserDAO {

	void addUser(User user);
	User getUser(int userId);
	void updateUser(User user);
	void deleteUser(int userId);
	List<User> getAllUsers();
	User getUserByUsername(String username);
}
