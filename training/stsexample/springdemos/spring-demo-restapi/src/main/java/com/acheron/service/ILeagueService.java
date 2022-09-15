package com.acheron.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.acheron.model.League;
import com.acheron.model.LeagueView;

@Service
public interface ILeagueService {

	League addLeague(League league);

	void updateLeague(League league);

	void deleteLeague(int leagueId);

	League getById(int leagueId);

	List<League> getAllLeague();

	// Retrieving from view
	List<LeagueView> getLeagueDetails();

	// calling stored Procedure
	Integer getLeagueCount(String country);

	// int getLeagueCount(String country);
	// named query
	List<League> getLeagueByBoard(String boardName);
}
