package com.acheron.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.acheron.model.Sports;
import com.acheron.service.ISportService;

@RestController
@RequestMapping("ics-league-api")
@CrossOrigin("http://localhost:4200")
public class SportsController {
	@Autowired
	ISportService sportService;
	
	@GetMapping("/sports")
	public List<Sports> getAllSport() {
		return sportService.getAllSport();
	}
	@GetMapping("/sports/sportsId")
	public Sports getById(@PathVariable("sportsId")int sportsId) {
		return sportService.getById(sportsId);
	}

}
