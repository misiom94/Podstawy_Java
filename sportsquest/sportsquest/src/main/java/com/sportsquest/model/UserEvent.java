package com.sportsquest.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.sportsquest.model.User;

@Entity
@Table(name="User_events")
public class UserEvent{
	
	@Id
	@GeneratedValue
	private Integer user_event_id;
	
	
	private Integer event_id;
	
	
	//private Integer user_id;
	@ManyToOne
	@JoinColumn(name="user_id", referencedColumnName="user_id")
	private User user;	
	

	public Integer getEventId() {
		return event_id;
	}

	public User getUser() {
		return user;
	}

		

}
