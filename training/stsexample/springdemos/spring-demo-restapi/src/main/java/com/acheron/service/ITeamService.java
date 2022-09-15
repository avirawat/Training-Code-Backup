package com.acheron.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.acheron.model.Team;

@Service
public interface ITeamService {

	Team addTeam(Team team);

	void updateTeam(Team team);

	void deleteTeam(int teamId);

	Team getById(int teamId);

	List<Team> getAllTeam();
	
	List<Team> getByPlayerName(String playerName);
}
