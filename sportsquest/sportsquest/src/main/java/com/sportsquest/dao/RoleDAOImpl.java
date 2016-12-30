package com.sportsquest.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sportsquest.model.Role;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * Implementacja metod interfejsu RoleDAO. Zbiór metod wykonujących operacje na tabeli Roles  w bazie danych.
 * 
 * @author Mateusz Orczykowski
 *
 */
@Repository
public class RoleDAOImpl implements RoleDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	/**
	 * Metoda wykonuje zapytanie w tebeli Roles w bazie danych Zwraca rolę o podanym numerze ID.
	 */
	public Role getRole(int id) {
		Role role = (Role) getCurrentSession().load(Role.class, id);
		return role;
	}

}
