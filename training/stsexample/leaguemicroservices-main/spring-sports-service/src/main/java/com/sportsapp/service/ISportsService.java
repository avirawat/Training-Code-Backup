package com.sportsapp.service;

import java.util.List;

import com.sportsapp.model.Sports;

public interface ISportsService {
	Sports addSports(Sports sports);
	Sports getById(int sportsId);
	List<Sports> getAll();
	
	
}
