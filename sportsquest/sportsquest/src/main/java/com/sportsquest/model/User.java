package com.sportsquest.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.sportsquest.model.User;


/**
 * Klasa która odwzorowuje tabelę Users z bazy danych.
 * @author Mateusz Orczykowski
 *
 */
@Entity
@Table(name="Users")
public class User {
	
	@Id
	@GeneratedValue
	private Integer user_id;
	
	private String login;
	
	private String password;
	
	private String name;
	
	private String surname;
	
	private String city;
	
	private Integer blocked;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinTable(name="User_roles",
		joinColumns = {@JoinColumn(name="user_id", referencedColumnName="user_id")},
		inverseJoinColumns = {@JoinColumn(name="role_id", referencedColumnName="role_id")}
	)
	private Role role;	
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinTable(name="User_events", 
		joinColumns = {@JoinColumn(name="user_id", referencedColumnName="user_id")},
		inverseJoinColumns = {@JoinColumn(name="event_id", referencedColumnName="event_id")}
	)
	private Set<Event> userEvents;
	


	/**
	 * 
	 * @return {@link User#user_id}
	 */
	public Integer getUserId() {
		return user_id;
	}

	/**
	 * 
	 * @return {@link User#login}
	 */
	public String getLogin() {
		return login;
	}
	/**
	 * 
	 * @return {@link User#password}
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * 
	 * @return {@link User#role}
	 */
	public Role getRole() {
		return role;
	}

	/**
	 * 
	 * @return {@link User#name}
	 */
	public String getName() {
		return name;
	}

	/**
	 * 
	 * @return {@link User#surname}
	 */
	public String getSurname() {
		return surname;
	}

	/**
	 * 
	 * @return {@link User#city}
	 */
	public String getCity() {
		return city;
	}

	/**
	 * 
	 * @return {@link User#userEvents}
	 */
	public Set<Event> getUserEvents() {
		return userEvents;
	}

	/**
	 * 
	 * @return {@link User#blocked}
	 */
	public Integer getBlocked() {
		return blocked;
	}

		
	
	

}
