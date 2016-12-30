package com.sportsquest.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

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
	
	

	public String getSportName() {
		return type;
	}


	public Integer getAccepted() {
		return accepted;
	}

	
	
}
