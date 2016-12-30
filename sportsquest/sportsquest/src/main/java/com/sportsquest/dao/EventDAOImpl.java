package com.sportsquest.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sportsquest.model.Event;
import com.sportsquest.model.Sport;
import com.sportsquest.model.User;

/**
 * 
 * @author Mateusz Orczykowski
 * 
 * Implementacja interfejsu EventDAO. Zbiór metod wykonujących operacje na tabeli Events w bazie danych.
 *
 */
@Repository
public class EventDAOImpl implements EventDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	private Session openSession() {
		return sessionFactory.getCurrentSession();
	}
	
	
	/**
	 * 
	 * Metoda dodająca do tabeli Events nowy rekord..
	 * Tworzenie nowego wydarzenia.
	 */
	public void addEvent(String name, String date, String city, String address, Integer host_id, Integer sport_id,String desc)
	{
		String sql = "INSERT INTO Events (name, date, city, address, host_id ,sport_id,description) VALUES ('" + name +"', '"+ date +"', '"+ city +"', '"+ address +"','"+ host_id +"', '"+ sport_id +"','"+ desc +"')";
		SQLQuery query = openSession().createSQLQuery(sql);
		query.executeUpdate();
	}
	

	/**
	 * Metoda wykonująca zapytanie na tabeli Events w bazie danych. Zwracająca listę wszystkich wydarzeń.
	 * 
	 * @return  List lub null
	 */
	public List<Event> getAllEvents()
	{
		List<Event> eventList = new ArrayList<Event>();
		String sql="from Event";
		Query query = openSession().createQuery(sql);
		
		eventList = query.list();
		if (eventList.size() > 0)
			return eventList;
		else
			return null;	
	}
	/**
	 * Metoda wykonująca zapytanie na tabeli Events w bazie danych. Zwracająca listę wszystkich wydarzeń posortowanych według daty wydarzenia.
	 * 
	 * @return  List lub null
	 */
	public List<Event>  getAllEventsDate()
	{
		List<Event> eventList = new ArrayList<Event>();
		String sql="from Event order by date ASC";
		Query query = openSession().createQuery(sql);
		
		eventList = query.list();
		if (eventList.size() > 0)
			return eventList;
		else
			return null;	
	}
	/**
	 * Metoda wykonująca zapytanie na tabeli Events w bazie danych Zwraca wydarzenie o pidanym numerze ID.
	 * 
	 * @return {@link Event}
	 * @see Event
	 */
	public Event getEvent(Integer event_id) {
		List<Event>eventList = new ArrayList<Event>();
		Query query = openSession().createQuery("from Event where event_id = :event_id");
		query.setParameter("event_id", event_id);
		eventList = query.list();
		if (eventList.size() > 0)
			return eventList.get(0);
		else
			return null;	
	}
	/**
	 * Metoda usuwająca wiersz o podanym numerze ID z tabeli Events w bazie danych.
	 * Usuwanie wydarzenia po numerze ID.
	 */
	public void deleteEvent(Integer event_id)
	{
		String sql = "delete from Events where event_id = :event_id";
		SQLQuery query = openSession().createSQLQuery(sql);
		query.setParameter("event_id", event_id);
		query.executeUpdate();
	}
	/**
	 * Metoda usuwająca wiersz o podanym ID użytkownika z tabeli Events w bazie danych.
	 * Usuwanie wydarzenia którego autorem jest okreslony użytkownik.
	 * 
	 */
	public void deleteEventUser(Integer user_id)
	{
		String sql = "delete from Events where host_id = :user_id";
		SQLQuery query = openSession().createSQLQuery(sql);
		query.setParameter("user_id", user_id);
		query.executeUpdate();
	}
	

}
