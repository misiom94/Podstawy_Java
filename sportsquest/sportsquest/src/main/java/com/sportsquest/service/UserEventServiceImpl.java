package com.sportsquest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sportsquest.dao.UserEventDAO;
import com.sportsquest.model.UserEvent;

/**
 * Klasa zawierająca odwołania do metod z interfejsu UserEventDAO tak by mozna było używać je w kontolerach nawigacyjnych.
 * 
 * @author Mateusz Orczykowski
 *
 */
@Service
@Transactional
public class UserEventServiceImpl  implements UserEventService{

	@Autowired
	private UserEventDAO userEventDAO;
	
	
	public void addUserEvent(Integer user_id, Integer event_id)
	{
		userEventDAO.addUserEvent(user_id, event_id);
	}
	public List<UserEvent> getUserEvent()
	{
		return userEventDAO.getUserEvent();
	}
	public List<UserEvent> getUserEventId(Integer event_id)
	{
		return userEventDAO.getUserEventId(event_id);
	}
	public void removeUserEvent(Integer user_id, Integer event_id)
	{
		userEventDAO.removeUserEvent(user_id, event_id);
	}
	public void removeAllUserEventId(Integer event_id)
	{
		userEventDAO.removeAllUserEventId(event_id);
	}
	public void removeUser(Integer user_id)
	{
		userEventDAO.removeUser(user_id);
	}
}
