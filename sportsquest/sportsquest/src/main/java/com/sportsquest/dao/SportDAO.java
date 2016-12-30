package com.sportsquest.dao;

import java.util.List;

import com.sportsquest.model.Sport;

public interface SportDAO {

	
	public List<Sport> getAllSports();
	public List<Sport> getAcceptedSports();
	public List<Sport> getNotAcceptedSports();
	public void acceptSport(Integer sportId);
	public void deleteSport(Integer sportId);
	public void addSport(String sportName);
}
