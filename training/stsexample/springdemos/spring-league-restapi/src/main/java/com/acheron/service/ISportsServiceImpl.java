package com.acheron.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acheron.model.Sports;
import com.acheron.model.SportView;
import com.acheron.repository.ISportsRepository;
@Service
public class ISportsServiceImpl implements ISportsService {
    @Autowired  
	ISportsRepository sportsRepository;
	@Override
	public Sports addSports(Sports sports) {
		return sportsRepository.save(sports);
	}

	@Override
	public void updateSports(Sports sports) {
  sportsRepository.save(sports);
	}

	@Override
	public void deleteSports(int sportsId) {
 sportsRepository.deleteById(sportsId);
	}

	@Override
	public Sports getById(int sportsId) {
		return sportsRepository.getById(sportsId);
	}

	@Override
	public List<Sports> getall() {
		return sportsRepository.findAll();
	}

	@Override
	public List<SportView> getSportsDetails() {
		return sportsRepository.getSportsDetails();
	}

}
