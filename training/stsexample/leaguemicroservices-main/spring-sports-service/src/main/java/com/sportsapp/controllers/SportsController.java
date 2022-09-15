package com.sportsapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sportsapp.model.Sports;
import com.sportsapp.service.ISportsService;

@RestController
@RequestMapping("ics-sports-api")
public class SportsController {
	
	@Autowired
	ISportsService sportsService;
	
	@GetMapping("/sports")
	public List<Sports> getAll(){
		return sportsService.getAll();
	}
	@GetMapping("/sports/{sportsId}")
	public Sports getById(@PathVariable("sportsId")int sportsId){
		return sportsService.getById(sportsId);
	}
}
