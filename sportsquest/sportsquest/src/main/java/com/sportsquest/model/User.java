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
	


	public Integer getUserId() {
		return user_id;
	}

	
	public String getLogin() {
		return login;
	}

	public String getPassword() {
		return password;
	}

	
	public Role getRole() {
		return role;
	}

	
	public String getName() {
		return name;
	}

	
	public String getSurname() {
		return surname;
	}

	
	public String getCity() {
		return city;
	}

	
	public Set<Event> getUserEvents() {
		return userEvents;
	}


	public Integer getBlocked() {
		return blocked;
	}

		
	
	

}
