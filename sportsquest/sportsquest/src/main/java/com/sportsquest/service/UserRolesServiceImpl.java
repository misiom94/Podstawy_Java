package com.sportsquest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sportsquest.dao.UserRolesDAO;

/**
 * Klasa zawierająca odwołania do metod z interfejsu UserRolesDAO tak by mozna było używać je w kontolerach nawigacyjnych.
 * 
 * @author Mateusz Orczykowski
 *
 */
@Service
@Transactional
public class UserRolesServiceImpl implements UserRolesService {

	
	@Autowired
	private UserRolesDAO roleusersDAO;
	
	@Override
	public void add(Integer userId, Integer roleId) {
		
		roleusersDAO.add(userId, roleId);
	}

	@Override
	public void removeUserRole(Integer user_id) {
		roleusersDAO.removeUserRole(user_id);
		
	}

	@Override
	public void editRole(Integer user_id, Integer roleID) {
		roleusersDAO.editRole(user_id, roleID);
		
	}

	/*@Override
	public void editUserRoles(Integer userId, Integer roleId) {
		roleusersDAO.editUserRoles(userId, roleId);
		
	}
*/

}
