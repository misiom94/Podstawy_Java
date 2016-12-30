package com.sportsquest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sportsquest.dao.RoleDAO;
import com.sportsquest.model.Role;

/**
 * Klasa zawierająca odwołania do metod z interfejsu RoleDAO tak by mozna było używać je w kontolerach nawigacyjnych.
 * 
 * @author Mateusz Orczykowski
 *
 */
@Service
@Transactional
public class RoleServiceImpl implements RoleService {
	
	@Autowired
	private RoleDAO roleDAO;

	public Role getRole(int id) {
		return roleDAO.getRole(id);
	}

}
