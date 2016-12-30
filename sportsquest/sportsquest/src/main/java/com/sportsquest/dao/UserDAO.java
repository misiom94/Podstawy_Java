package com.sportsquest.dao;

import java.util.List;

import com.sportsquest.model.User;

public interface UserDAO {
	
	public User getUser(String login);
	public User getUserId(Integer user_id);
	public void changePassword(Integer user_id, String password);
	public List<User> getAllUsers();
	public void addUser(String name, String surname, String login, String password,String city);
	public Boolean checkLoginAvailable(String login);
	public void deleteUser(Integer userId);
	public void activateUser(Integer userId);
	public void blockUser(Integer userId);
}
