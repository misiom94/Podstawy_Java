package com.sportsquest.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Klasa która odwzorowuje tabelę User_roles z bazy danych.
 * @author Mateusz Orczykowski
 *
 */
@Entity
@Table(name="User_roles")
public class UserRoles {

	@Id
	@GeneratedValue
	@Column(name="user_id")
	private Integer user_id;
	
	@Column(name="role_id")
	private Integer role_id;
	
	
	/**
	 * 
	 * @return {@link UserRoles#role_id}
	 */
	public Integer getRoleId(){
		return role_id;
	}
	
	/**
	 * 
	 * @return {@link UserRoles#user_id}
	 */
	public Integer getUserId(){
		return user_id;
	}
	
	
}
