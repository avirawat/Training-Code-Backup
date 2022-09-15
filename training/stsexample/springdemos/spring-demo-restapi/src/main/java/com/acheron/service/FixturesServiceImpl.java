package com.acheron.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.acheron.model.Fixtures;
import com.acheron.repository.IFixturesRepository;

@Service
public class FixturesServiceImpl implements IFixturesService{

	@Autowired
	private IFixturesRepository fixturesRepository;

	@Override
	public Fixtures addFixtures(Fixtures fixtures) {
		return fixturesRepository.save(fixtures);
	}

	@Override
	public void updateFixtures(Fixtures fixtures) {
		fixturesRepository.save(fixtures);
	}

	@Override
	public void deleteFixtures(int fixturesId) {
		fixturesRepository.deleteById(fixturesId);;
	}

	@Override
	public List<Fixtures> getAll() {
		
		Sort sort=Sort.by("squads");
		return fixturesRepository.findAll(sort);
	}

	@Override
	public Fixtures getById(int fixturesId) {
		return fixturesRepository.findById(fixturesId).get();
	}

	@Override
	public List<Fixtures> getFixturesByLeague(String leagueName) {
		return null;
	}

	@Override
	public List<Fixtures> getFixturesByTeamName(String teamname) {
		
		return null;
	}


}
