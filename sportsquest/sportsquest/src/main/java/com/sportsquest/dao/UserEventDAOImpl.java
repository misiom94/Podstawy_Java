package com.sportsquest.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sportsquest.model.UserEvent;

/**
 * Implementacja metod interfejsu UserEventDAO. Zbiór metod wykonujących operacje na tabeli User_event  w bazie danych.
 * 
 * @author Mateusz Orczykowski
 *
 */
@Repository
public class UserEventDAOImpl implements UserEventDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session openSession() {
		return sessionFactory.getCurrentSession();
	}
	
	/**
	 * Metoda wstawia wiersz w tabeli User_events w bazie danych.
	 * Dodawanie uzytkowników do istniejącego wydarzenia.
	 */
	public void addUserEvent(Integer user_id, Integer event_id)
	{
		String sql = "INSERT INTO User_events (user_id,event_id) VALUES ('" + user_id +"', '"+ event_id +"')";
		SQLQuery query = openSession().createSQLQuery(sql);
		query.executeUpdate();
	}

	/**
	 * Metoda wykonuje zapytanie na tabeli User_events w bazie danych i zwraca liste wszyskich rekordów.
	 * @return List lub null
	 * 
	 * @see UserEvent
	 */
	public List<UserEvent> getUserEvent()
	{
		List<UserEvent> eventList = new ArrayList<UserEvent>();
		
		Query query = openSession().createQuery("from UserEvent ");
		eventList = query.list();
		 
		return eventList;
			}
	
	/**
	 * Metoda wykonuje zapytanie na tabeli User_events w bazie danych i zwraca liste rekordów o określonym numerze ID wydarzenia.
	 * 
	 * @return List lub null
	 * 
	 * @see UserEvent
	 */
	public List<UserEvent> getUserEventId(Integer event_id)
	{
		List<UserEvent> eventList = new ArrayList<UserEvent>();
		
		Query query = openSession().createQuery("from UserEvent WHERE event_id = '"+ event_id + "'");
		eventList = query.list();
		 
		return eventList;
	}
	/**
	 * Medtoda wykonuje operacje usunięcia rekordu z tabeli User_events o podanym numerze ID użytkownika oraz wydarzenia
	 * Usuwanie użytkownika z istniejącego wydarzenia.
	 */
	public void removeUserEvent(Integer user_id, Integer event_id){
		
		String query = "delete from User_events where user_id="+user_id+" and "+event_id;
		SQLQuery sqlQuery = openSession().createSQLQuery(query);
		sqlQuery.executeUpdate();
		
	}
	/**
	 * Metoda usuwa rekordy z tabeli User_events w bazie danych które zawierają określony numer ID uzytkownika.
	 * Usuwanie uzytkownika z istniejących wydarzeń.
	 */
	public void removeUser(Integer user_id)
	{
		String query = "delete from User_events where user_id="+user_id;
		SQLQuery sqlQuery = openSession().createSQLQuery(query);
		sqlQuery.executeUpdate();
	}
	/**
	 * Metoda usuwa rekordy z tabeli User_events w bazie danych które zawierają określony numer ID wydarzenia.
	 * Usuwanie wszystkich uzytkowników z danego wydarzenia.
	 */
	public void removeAllUserEventId(Integer event_id){
		
		String query = "delete from User_events where event_id="+event_id;
		SQLQuery sqlQuery = openSession().createSQLQuery(query);
		sqlQuery.executeUpdate();
		
	}
}
