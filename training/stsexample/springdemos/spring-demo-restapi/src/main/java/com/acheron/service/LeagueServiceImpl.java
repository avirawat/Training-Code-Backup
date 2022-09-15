package com.acheron.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acheron.model.League;
import com.acheron.model.LeagueView;
import com.acheron.repository.ILeagueRepository;
@Service
public class LeagueServiceImpl implements ILeagueService{

	@Autowired
	ILeagueRepository leagueRepository;
	
	@Override
	public League addLeague(League league) {
		return leagueRepository.save(league);
	}

	@Override
	public void updateLeague(League league) {
		leagueRepository.save(league);
		
	}

	@Override
	public void deleteLeague(int leagueId) {
		leagueRepository.deleteById(leagueId);
		
	}

	@Override
	public League getById(int leagueId) {
		return leagueRepository.findById(leagueId).get();
	}

	@Override
	public List<League> getAllLeague() {
		return leagueRepository.findAll();
	}

	@Override
	public List<LeagueView> getLeagueDetails() {
		return leagueRepository.getLeagueDetails();
	}

	@Override
	public Integer getLeagueCount(String country) {
		return leagueRepository.GET_LEAGUE_COUNT(country);
		//return leagueRepository.getTotalLeagues(country);
	}

	@Override
	public List<League> getLeagueByBoard(String boardName) {
		return leagueRepository.findLeagueByBoard(boardName);
	}

	

}
