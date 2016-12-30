package com.sportsquest.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.sportsquest.model.User;

/**
 * Implementacja metod interfejsu UserDAO. Zbiór metod wykonujących operacje na tabeli Users  w bazie danych.
 * 
 * @author Mateusz Orczykowski
 *
 */
@Repository
public class UserDAOImpl implements UserDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session openSession() {
		return sessionFactory.getCurrentSession();
	}

	public User getUser(String login) {
		List<User> userList = new ArrayList<User>();
		Query query = openSession().createQuery("from User where login = :login");
		query.setParameter("login", login);
		userList = query.list();
		if (userList.size() > 0)
			return userList.get(0);
		else
			return null;	
	}
	
	public User getUserId(Integer user_id)
	{
		List<User> userList = new ArrayList<User>();
		Query query = openSession().createQuery("from User where user_id = :user_id");
		query.setParameter("user_id", user_id);
		userList = query.list();
		if (userList.size() > 0)
			return userList.get(0);
		else
			return null;	
	}
	
	public void changePassword(Integer user_id, String password)
	{
		String query = "UPDATE Users SET password = '"+ password +"' WHERE user_id = '"+ user_id + "'";
		SQLQuery sqlQuery = openSession().createSQLQuery(query);
		sqlQuery.executeUpdate();
		
	}
	public List<User> getAllUsers()
	{
		List<User> userList = new ArrayList<User>();
		String sql="from User";
		Query query = openSession().createQuery(sql);
		
		userList = query.list();
		if (userList.size() > 0)
			return userList;
		else
			return null;	
	}
	public void addUser(String name, String surname, String login, String password,String city)
	{
		String sql = "INSERT INTO Users (name, surname, login, password, city,role_id) VALUES ('" + name +"', '"+ surname +"', '"+ login +"', '"+ password +"', '"+ city +"','"+ 2 +"')";
		SQLQuery query = openSession().createSQLQuery(sql);
		query.executeUpdate();
	}
	
	public Boolean checkLoginAvailable(String login)
	{
		List<User> loginList = new ArrayList<User>();
		
		Query query = openSession().createQuery("from User where login = '"+ login +"'");
		
		loginList = query.list();
		
		if (loginList.size() == 0)
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}
	public void deleteUser(Integer userId)
	{
		String sql = "delete from Users where user_id = :user_id";
		SQLQuery query = openSession().createSQLQuery(sql);
		query.setParameter("user_id", userId);
		query.executeUpdate();
	}
	public void activateUser(Integer userId)
	{
		String query = "UPDATE Users SET blocked = 0 WHERE user_id = '"+ userId + "'";
		SQLQuery sqlQuery = openSession().createSQLQuery(query);
		sqlQuery.executeUpdate();
	}
	public void blockUser(Integer userId)
	{
		String query = "UPDATE Users SET blocked = 1 WHERE user_id = '"+ userId + "'";
		SQLQuery sqlQuery = openSession().createSQLQuery(query);
		sqlQuery.executeUpdate();
	}
	
	}
