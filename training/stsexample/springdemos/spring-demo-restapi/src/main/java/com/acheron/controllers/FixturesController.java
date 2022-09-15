package com.acheron.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.acheron.model.Fixtures;
import com.acheron.model.League;
import com.acheron.model.Sports;
import com.acheron.service.IFixturesService;
import com.acheron.service.ISportService;

@RestController
@RequestMapping("ics-league-api")
@CrossOrigin("http://localhost:4200")
public class FixturesController {
	@Autowired
	IFixturesService fixturesService;
	
	@GetMapping("/fixtures")
	public List<Fixtures> getAllFixtures() {
		return fixturesService.getAll();
	}
	@GetMapping("/fixtures/{fixturesId)")
	public Fixtures getById(@PathVariable("fixturesId")int fixturesId) {
		return fixturesService.getById(fixturesId);
	}

}
