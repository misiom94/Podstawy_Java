package com.sportsquest.dao;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Implementacja metod interfejsu UserRolesDAO. Zbiór metod wykonujących operacje na tabeli User_roles w bazie danych.
 * 
 * @author Mateusz Orczykowski
 *
 */
@Repository
public class UserRolesDAOImpl implements UserRolesDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	
	private Session openSession() {
		return sessionFactory.getCurrentSession();
	}
	
	/**
	 * Metoda wykonuje operację wstawienia nowego wiersza do tabeli User_roles w bazie danych.
	 * Dodanie nowej roli w systemie.
	 */
	@Override
	public void add(Integer userId, Integer roleId) {
		String query = "INSERT INTO User_roles (user_id, role_id) VALUES ('" + userId +"', '"+ roleId +"')";
		SQLQuery sqlQuery = openSession().createSQLQuery(query);
		sqlQuery.executeUpdate();
		
	}
	
	/**
	 * Metoda wykonuje operacje usunięcia wiersza z tabeli User_roles w bazie danych.
	 */
	@Override
	public void removeUserRole(Integer user_id) {
		String query = "delete from User_roles where user_id="+user_id;
		SQLQuery sqlQuery = openSession().createSQLQuery(query);
		sqlQuery.executeUpdate();
		
	}

	/**
	 * Metoda zmienia wartość pola role_id dla podanego numeru używtkownika.
	 * Do role_id można użyć tylko 1 lub 2.
	 */
	@Override
	public void editRole(Integer user_id, Integer roleID) {
		String query = "UPDATE User_roles SET role_id='"+roleID+"' where user_id='"+user_id+"'";
		SQLQuery sqlQuery = openSession().createSQLQuery(query);
		sqlQuery.executeUpdate();
		
	}


}
