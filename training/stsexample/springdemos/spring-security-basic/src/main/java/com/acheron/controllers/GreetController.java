package com.acheron.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetController {
	
	@RequestMapping("/greet")
	public String greet() {
		return "hava a nice day";
	}
}
