package com.acheron.service;

import java.util.List;

import com.acheron.model.League;
import com.acheron.model.LeagueView;

public interface ILeagueService {
	
	League addleague(League league);
	void updateleague(League league);
	void deleteleague(int leagueId);
	
	League getById(int leagueId);
	List<League> getall();
	
	//using named query
	List<League> getLeagueByBoard(String boardcity);
	
	
//retrieving from view
	List<LeagueView> getLeagueDeatails();
	
	//calling stored procedure
	Integer getLeagueCount(String country);
}
