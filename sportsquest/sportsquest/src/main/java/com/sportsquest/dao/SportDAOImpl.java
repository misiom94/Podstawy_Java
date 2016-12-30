package com.sportsquest.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sportsquest.model.Sport;

/**
 * Implementacja metod interfejsu SportDAO. Zbiór metod wykonujących operacje na tabeli Sports  w bazie danych.
 * 
 * @author Mateusz Orczykowski
 *
 */
@Repository
public class SportDAOImpl implements SportDAO{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	private Session openSession() {
		return sessionFactory.getCurrentSession();
	}
	
	
	/**
	 * Metoda wykonuje zapytanie na tabeli Sports w bazie danych. Zwraca listę wszystkich dyscyplin sportu zapisanych w bazie.
	 * @return List lub null
	 */
	public List<Sport> getAllSports()
	{
		List<Sport> sportList = new ArrayList<Sport>();
		String sql="from Sport";
		Query query = openSession().createQuery(sql);
		
		sportList = query.list();
		if (sportList.size() > 0)
			return sportList;
		else
			return null;	
	}
	/**
	 * Metoda wykonuje zapytanie na tabeli Sports w bazie danych. Zwraca listę wszystkich zaakceptowanych przez administratora dyscyplin sportu zapisanych w bazie.
	 * @return List lub null
	 */
	public List<Sport> getAcceptedSports()
	{
		List<Sport> sportList = new ArrayList<Sport>();
		String sql="from Sport where accepted=1 ";
		Query query = openSession().createQuery(sql);
		
		sportList = query.list();
		if (sportList.size() > 0)
			return sportList;
		else
			return null;	
	}
	/**
	 * Metoda wykonuje zapytanie na tabeli Sports w bazie danych. Zwraca listę wszystkich niezaakceptowanych przez administratora dyscyplin sportu zapisanych w bazie.
	 * @return List lub null
	 */
	public List<Sport> getNotAcceptedSports()
	{
		List<Sport> sportList = new ArrayList<Sport>();
		String sql="from Sport where accepted=0 ";
		Query query = openSession().createQuery(sql);
		
		sportList = query.list();
		if (sportList.size() > 0)
			return sportList;
		else
			return null;	
	}
	/**
	 * Metoda zmienia wartość pola accepted na 1 w tabeli Sports dla podanego numeru ID dyscypliny sportu.
	 * Akceptacja zaproponowanej przez uzytkownika nowej dyscypliny sportu.
	 */
	public void acceptSport(Integer sportId)
	{
		String sql = "UPDATE Sport SET accepted=1 WHERE sport_id = '"+ sportId + "'";
		
		Query query = openSession().createQuery(sql);
		
		query.executeUpdate();
	}
	/**
	 * Metoda usuwa z tabeli Sports rekord o podanym numerze ID.
	 */
	public void deleteSport(Integer sportId)
	{
		String sql = "delete from Sports where sport_id = :sport_id";
		SQLQuery query = openSession().createSQLQuery(sql);
		query.setParameter("sport_id", sportId);
		query.executeUpdate();
	}
	
	/**
	 * Metoda dodaje rekord do tabeli Sports w bazie danych z domyślną wartością 0 dla pola accepted.
	 * Proponowanie nowej dyscypliny sportu przez użytkownika
	 */
	public void addSport(String sportName)
	{
		String sql = "INSERT INTO Sports (type) VALUES ('" + sportName +"')";
		SQLQuery query = openSession().createSQLQuery(sql);
		query.executeUpdate();
	}
	

}
