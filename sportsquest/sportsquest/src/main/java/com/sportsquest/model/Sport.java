package com.sportsquest.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Klasa która odwzorowuje tabelę Sports z bazy danych.
 * @author Mateusz Orczykowski
 *
 */
@Entity
@Table(name="Sports")
public class Sport {
	
	@Id
	@GeneratedValue
	private Integer sport_id;
	
	private String type;
	
	private Integer accepted;
	
	public Integer getSportId()
	{
		return sport_id;
	}
	
	/**
	 * 
	 * @return {@link Sport#type}
	 */
	public String getSportName() {
		return type;
	}


	/**
	 * 
	 * @return {@link Sport#accepted}
	 */
	public Integer getAccepted() {
		return accepted;
	}

	
	
}
