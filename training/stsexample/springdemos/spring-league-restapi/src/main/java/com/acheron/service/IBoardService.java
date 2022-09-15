package com.acheron.service;

import java.util.List;

import com.acheron.model.League;
import com.acheron.model.Board;

public interface IBoardService {
	
	Board addowner(Board owner);
	void updateowner(Board owner);
	void deleteowner(int ownerId);
	
	Board getById(int ownerId);
	List<Board> getall();

}
