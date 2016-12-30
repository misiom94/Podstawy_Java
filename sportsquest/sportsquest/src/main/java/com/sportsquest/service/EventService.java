package com.sportsquest.service;

import java.util.List;

import com.sportsquest.model.Event;
import com.sportsquest.model.User;

public interface EventService {

	

	public void addEvent(String name, String date, String city, String address,Integer host_id, Integer sport_id,String desc);
	public List<Event> getAllEvents();
	public List<Event> getAllEventsDate();
	public Event getEvent(Integer event_id);
	public void deleteEvent(Integer event_id);
	public void deleteEventUser(Integer user_id);
}
