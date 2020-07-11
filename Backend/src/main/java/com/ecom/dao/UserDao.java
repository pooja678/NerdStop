package com.ecom.dao;

import java.util.List;

import com.ecom.model.User;

public interface UserDao {
	
	public boolean addUser(User user);
	public boolean deleteUser(int userId);
	public boolean updateUser(User user);
	public User getUserById(int userId);
	public List<User> getAllUser();
	public int getUserIdByUserEmail(String userEmail);
	
	public String getUserNameByUserId(int userId);
	
	public User getUserByEmail(String userEmail);
	
	public String getUserEmailByUserId(int userId);

}
