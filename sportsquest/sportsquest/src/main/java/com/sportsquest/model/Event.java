package com.sportsquest.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.sportsquest.model.Sport;



@Entity
@Table(name="Events")
public class Event {
	
	@Id
	@GeneratedValue
	@Column(name="event_id")
	private Integer event_id;
	
	private String name;
	private Date date;
	private String city;
	
	private Integer host_id;
	
	private String description;
	
	@ManyToOne
	@JoinColumn(name="sport_id", referencedColumnName="sport_id")
	private Sport sport;	
	
	private String address;
	
	public Integer getEventId() {
		return event_id;
	}
	
	public String getEventName() {
		return name;
	}
	
	public Date getDate() {
		return date;
	}
	
	public String getCity() {
		return city;
	}
	
	
	public Integer getHost_id() {
		return host_id;
	}
		
	public String getDescription() {
		return description;
	}

	public Sport getSport() {
		return sport;
	}
	
	public String getAddress() {
		return address;
	}
	
	
	
		
	
	
	
	

}
