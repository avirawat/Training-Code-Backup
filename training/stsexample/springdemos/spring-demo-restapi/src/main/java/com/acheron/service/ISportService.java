package com.acheron.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.acheron.model.Sports;
import com.acheron.model.SportView;

@Service
public interface ISportService {

	Sports addSport(Sports sports);

	void updateSport(Sports sports);

	void deleteSport(int sportsId);

	Sports getById(int sportsId);

	List<Sports> getAllSport();

	List<SportView> getAllSports();

}
