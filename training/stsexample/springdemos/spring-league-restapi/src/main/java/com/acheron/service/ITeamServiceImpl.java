package com.acheron.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.acheron.model.Team;
import com.acheron.repository.ITeamRepository;

public class ITeamServiceImpl implements ITeamService {
	@Autowired
	ITeamRepository teamRepository;

	@Override
	public Team addowner(Team team) {
		return teamRepository.save(team);
	}

	@Override
	public void updateowner(Team team) {
		teamRepository.save(team);
	}

	@Override
	public void deleteowner(int teamId) {
		teamRepository.deleteById(teamId);
	}

	@Override
	public Team getById(int teamId) {
		return teamRepository.getById(teamId);
	}

	@Override
	public List<Team> getall() {
		return teamRepository.findAll();
	}

}
