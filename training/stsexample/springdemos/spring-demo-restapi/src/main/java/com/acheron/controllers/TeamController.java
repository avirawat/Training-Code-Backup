package com.acheron.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.acheron.model.Team;
import com.acheron.service.ITeamService;

@RestController
@RequestMapping("ics-league-api")
@CrossOrigin("http://localhost:4200")
public class TeamController {
	@Autowired
	ITeamService teamService;
	
	@GetMapping("/teams")
	public List<Team> getAllTeam() {
		return teamService.getAllTeam();
	}
	
	@GetMapping("/teams/{teamId}")
	public Team getById(@PathVariable("teamId")int teamId) {
		return teamService.getById(teamId);
	}

}
