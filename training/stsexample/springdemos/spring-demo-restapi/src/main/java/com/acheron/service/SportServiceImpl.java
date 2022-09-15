package com.acheron.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acheron.model.Sports;
import com.acheron.model.SportView;
import com.acheron.repository.ISportsRepository;

@Service
public class SportServiceImpl implements ISportService {

	@Autowired
	ISportsRepository sportRepository;
	
	@Override
	public Sports addSport(Sports sport) {
		return sportRepository.save(sport);
	}

	@Override
	public void updateSport(Sports sport) {
	sportRepository.save(sport);

	}

	@Override
	public void deleteSport(int sportId) {
		sportRepository.deleteById(sportId);

	}

	@Override
	public Sports getById(int sportId) {
		return sportRepository.findById(sportId).get();
	}

	@Override
	public List<Sports> getAllSport() {
		return sportRepository.findAll();
	}

	@Override
	public List<SportView> getAllSports() {
		return sportRepository.findAllSports();
	}

}
