package com.sportsquest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sportsquest.dao.EventDAO;
import com.sportsquest.model.Event;
import com.sportsquest.model.User;

@Service
@Transactional
public class EventServiceImpl implements EventService {

	@Autowired
	private EventDAO eventDAO;
	
	
	
	
	public void addEvent(String name, String date, String city, String address, Integer host_id, Integer sport_id,String desc)
	{
		eventDAO.addEvent(name, date, city, address, host_id, sport_id, desc);
	}
	public List<Event> getAllEvents()
	{
		return eventDAO.getAllEvents();
	}
	public List<Event> getAllEventsDate()
	{
		return eventDAO.getAllEventsDate();
	}
	public Event getEvent(Integer event_id)
	{
		return eventDAO.getEvent(event_id);
	}
	public void deleteEvent(Integer event_id)
	{
		eventDAO.deleteEvent(event_id);
	}

	public void deleteEventUser(Integer user_id)
	{
		eventDAO.deleteEventUser(user_id);
	}
}
