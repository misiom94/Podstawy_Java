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

@Repository
public class UserEventDAOImpl implements UserEventDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session openSession() {
		return sessionFactory.getCurrentSession();
	}
	
	public void addUserEvent(Integer user_id, Integer event_id)
	{
		String sql = "INSERT INTO User_events (user_id,event_id) VALUES ('" + user_id +"', '"+ event_id +"')";
		SQLQuery query = openSession().createSQLQuery(sql);
		query.executeUpdate();
	}

	public List<UserEvent> getUserEvent()
	{
		List<UserEvent> eventList = new ArrayList<UserEvent>();
		
		Query query = openSession().createQuery("from UserEvent ");
		eventList = query.list();
		 
		return eventList;
			}
	
	public List<UserEvent> getUserEventId(Integer event_id)
	{
		List<UserEvent> eventList = new ArrayList<UserEvent>();
		
		Query query = openSession().createQuery("from UserEvent WHERE event_id = '"+ event_id + "'");
		eventList = query.list();
		 
		return eventList;
	}
	public void removeUserEvent(Integer user_id, Integer event_id){
		
		String query = "delete from User_events where user_id="+user_id+" and "+event_id;
		SQLQuery sqlQuery = openSession().createSQLQuery(query);
		sqlQuery.executeUpdate();
		
	}
	public void removeUser(Integer user_id)
	{
		String query = "delete from User_events where user_id="+user_id;
		SQLQuery sqlQuery = openSession().createSQLQuery(query);
		sqlQuery.executeUpdate();
	}
public void removeAllUserEventId(Integer event_id){
		
		String query = "delete from User_events where event_id="+event_id;
		SQLQuery sqlQuery = openSession().createSQLQuery(query);
		sqlQuery.executeUpdate();
		
	}
}
