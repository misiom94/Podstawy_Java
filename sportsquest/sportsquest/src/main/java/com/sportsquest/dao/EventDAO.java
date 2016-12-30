package com.sportsquest.dao;

import java.util.List;

import com.sportsquest.model.Event;
import com.sportsquest.model.User;

public  interface EventDAO {

	
	
	public void addEvent(String name, String date, String city, String address, Integer host_id, Integer sport_id,String desc);
	public List<Event> getAllEvents();
	public Event getEvent(Integer event_id);
	public void deleteEvent(Integer event_id);
	public void deleteEventUser(Integer user_id);
	public List<Event> getAllEventsDate();
	
}