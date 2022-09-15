package com.acheron.service;

import java.util.List;

import com.acheron.model.Team;

public interface ITeamService {
	
	Team addowner(Team team);
	void updateowner(Team team);
	void deleteowner(int teamId);
	
	Team getById(int teamId);
	List<Team> getall();

}
