package com.sportsquest.service;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sportsquest.dao.UserDAO;
import com.sportsquest.model.User;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDAO userDAO;

	public User getUser(String login) {
		return userDAO.getUser(login);
	}

	public void changePassword(Integer user_id, String password)
	{
		userDAO.changePassword(user_id, password);
	}
	
	public List<User> getAllUsers()
	{
		return userDAO.getAllUsers();
	}
	public void addUser(String name, String surname, String login, String password,String city)
	{
		userDAO.addUser(name, surname, login, password, city);
	}
	public Boolean checkLoginAvailable(String login)
	{
		return userDAO.checkLoginAvailable(login);
	}
	public User getUserId(Integer user_id)
	{
		return userDAO.getUserId(user_id);
	}
	public void deleteUser(Integer userId)
	{
		userDAO.deleteUser(userId);
	}
	public void activateUser(Integer userId)
	{
		userDAO.activateUser(userId);
	}
	public void blockUser(Integer userId)
	{
		userDAO.blockUser(userId);
	}
}
