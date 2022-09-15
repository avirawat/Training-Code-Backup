package com.acheron.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.acheron.model.Fixtures;

@Service
public interface IFixturesService {

	Fixtures addFixtures(Fixtures fixtures);

	void updateFixtures(Fixtures fixtures);

	void deleteFixtures(int fixturesId);

	Fixtures getById(int fixturesId);

	List<Fixtures> getAll();
	
	List<Fixtures> getFixturesByLeague(String leagueName);
	
	List<Fixtures> getFixturesByTeamName(String teamname);
}
