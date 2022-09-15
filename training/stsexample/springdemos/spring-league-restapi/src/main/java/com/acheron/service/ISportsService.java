package com.acheron.service;

import java.util.List;

import com.acheron.model.Sports;
import com.acheron.model.SportView;

public interface ISportsService {
	
	Sports addSports(Sports sports);
	void updateSports(Sports sports);
	void deleteSports(int sportsId);
	
	Sports getById(int matchId);
	List<Sports> getall();
  
	//for view
	List<SportView> getSportsDetails();
	

}
