package com.sportsquest.service;

import java.util.List;

import com.sportsquest.model.UserEvent;

public interface UserEventService {

	
	public void addUserEvent(Integer user_id, Integer event_id);
	public List<UserEvent> getUserEvent();
	public List<UserEvent> getUserEventId(Integer event_id);
	public void removeUserEvent(Integer user_id, Integer event_id);
	public void removeAllUserEventId(Integer event_id);
	public void removeUser(Integer user_id);
}
