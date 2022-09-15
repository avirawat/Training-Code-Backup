package com.acheron.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.acheron.model.Player;
import com.acheron.model.Sports;
import com.acheron.service.IPlayerService;
import com.acheron.service.ISportService;

@RestController
@RequestMapping("ics-league-api")
@CrossOrigin("http://localhost:4200")
public class PlayerController {
	//@Autowired
//	IPlayerService playerService;
//	
//	@GetMapping("/players")
//	public List<Player> getAllPlayers() {
//		return playerService.getAllPlayer();
//	}

}
