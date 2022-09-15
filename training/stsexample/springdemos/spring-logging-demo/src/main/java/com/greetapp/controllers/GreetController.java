package com.greetapp.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetController {
	
	Logger logger =LoggerFactory.getLogger(GreetController.class);
	@RequestMapping("/greet")
	public String greet() {
		logger.trace("inside greet -trace");
		logger.debug("inside greet -debug");
		logger.info("inside greet -info");
		logger.warn("inside greet -warn");
		logger.error("inside greet -error");
		return "Hello";
	}
	//http://localhost:8080/userDetails/Priya/Hyd
	@RequestMapping("/userDetails/{name}/{city}")
	public String userDetails(@PathVariable("name")String username,@PathVariable("city") String city) {
		if(city.equals("ban")) {
			logger.debug("checking city");
			logger.warn("invalid input");
		}
		if(username.equals("Priya")) {
			logger.info("correct username "+username);
			return "welcome "+username+" city "+city;
		}
		else {
			logger.error("wrong user");
			return "wrong user";
		}
	}
}
