/**
 * 
 */
package com.acheron.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acheron.model.League;
import com.acheron.model.LeagueView;
import com.acheron.repository.ILeagueRepository;

/**
 * @author SumanD
 *
 */
@Service
public class ILeagueServiceImpl implements ILeagueService {
	@Autowired
	ILeagueRepository leagueRepository;

	@Override
	public League addleague(League league) {
		return leagueRepository.save(league);
	}

	@Override
	public void updateleague(League league) {
		leagueRepository.save(league);
	}

	@Override
	public void deleteleague(int leagueId) {
		leagueRepository.deleteById(leagueId);
	}

	@Override
	public League getById(int leagueId) {
		return leagueRepository.getById(leagueId);
	}

	@Override
	public List<League> getall() {
		return leagueRepository.findAll();
	}

	@Override
	public List<LeagueView> getLeagueDeatails() {
		return leagueRepository.getLeagueDetails();
	}

	@Override
	public Integer getLeagueCount(String country) {
		return leagueRepository.getLeagueCount(country);
		// return leagueRepository.getTotalLeague(country);
	}

	@Override
	public List<League> getLeagueByBoard(String boardcity) {
		return leagueRepository.findLeagueByBoard(boardcity);
	}

}
