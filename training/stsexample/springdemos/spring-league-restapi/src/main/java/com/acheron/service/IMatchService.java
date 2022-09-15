package com.acheron.service;

import java.util.Set;

import com.acheron.model.League;
import com.acheron.model.Matches;

public interface IMatchService {
	
	Matches addleague(Matches match);
	void updateleague(Matches match);
	void deleteleague(int matchId);
	
	Matches getById(int matchId);
	Set<Matches> getall();

}
