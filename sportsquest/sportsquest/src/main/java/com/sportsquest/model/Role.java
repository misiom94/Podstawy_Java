package com.sportsquest.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Roles")
public class Role {
	
	@Id
	@GeneratedValue
	private Integer role_id;
	
	private String role;
	
	
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinTable(name="User_roles", 
		joinColumns = {@JoinColumn(name="role_id", referencedColumnName="role_id")},
		inverseJoinColumns = {@JoinColumn(name="user_id", referencedColumnName="user_id")}
	)
	private Set<User> userRoles;

	
	
	public Integer getId() {
		return role_id;
	}

	
	public String getRole() {
		return role;
	}

	
	
}
