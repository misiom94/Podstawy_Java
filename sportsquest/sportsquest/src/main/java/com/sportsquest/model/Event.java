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


/**
 * Klasa która odwzorowuje tabelę Events z bazy danych.
 * @author Mateusz Orczykowski
 *
 */
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
	
	/**
	 * 
	 * @return {@link Event#event_id}
	 */
	public Integer getEventId() {
		return event_id;
	}
	
	/**
	 * 
	 * @return {@link Event#name}
	 */
	public String getEventName() {
		return name;
	}
	/**
	 * 
	 * @return {@link Event#date}
	 */
	public Date getDate() {
		return date;
	}
	
	/**
	 * 
	 * @return {@link Event#city}
	 */
	public String getCity() {
		return city;
	}
	
	/**
	 * 
	 * @return {@link Event#host_id}
	 */
	public Integer getHost_id() {
		return host_id;
	}
	/**
	 * 
	 * @return {@link Event#description}
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * 
	 * @return {@link Sport}
	 */
	public Sport getSport() {
		return sport;
	}

	/**
	 * 
	 * @return {@link Event#address}
	 */
	public String getAddress() {
		return address;
	}
	
	
	
		
	
	
	
	

}
