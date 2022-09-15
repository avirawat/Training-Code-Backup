package com.acheron.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.acheron.model.Player;

@Service
public interface IPlayerService {

	Player addPlayer(Player player);

	void updatePlayer(Player player);

	void deletePlayer(int playerId);

	Player getById(int playerId);

	List<Player> getAllPlayer();
}
