package com.sportsquest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sportsquest.dao.SportDAO;
import com.sportsquest.model.Sport;

/**
 * Klasa zawierająca odwołania do metod z interfejsu EventDAO tak by mozna było używać je w kontolerach nawigacyjnych.
 * 
 * @author Mateusz Orczykowski
 *
 */
@Service
@Transactional
public class SportServiceImpl  implements SportService{
	
	@Autowired
	private SportDAO sportDAO;
	
	public List<Sport> getAllSports()
	{
		return sportDAO.getAllSports();
	}
	public List<Sport> getAcceptedSports()
	{
		return sportDAO.getAcceptedSports();
	}
	public List<Sport> getNotAcceptedSports()
	{
		return sportDAO.getNotAcceptedSports();
	}
	public void acceptSport(Integer sportId)
	{
		sportDAO.acceptSport(sportId);
	}
	public void deleteSport(Integer sportId)
	{
		sportDAO.deleteSport(sportId);
	}
	public void addSport(String sportName)
	{
		sportDAO.addSport(sportName);
	}
	

}
