package com.productapp.contollers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController  // for REST API
public class GreetController {
	
	//http://localhost:8080/greet
	@RequestMapping("/greet")
	public String greetMesage() {
		return "Have a good day !";
	}
	
	//http://localhost:8080/show
	@RequestMapping("/show")
	public String showMessage(@RequestParam("username")String username) {
		return "welcome "+username;
	}
	//http://localhost:8080/showDetails?username=Avi&city=Ayodhya
	@RequestMapping("/showDetails") // data is taken from form
	public String showDetails(@RequestParam("username")String username,@RequestParam("city")String city) {
		return "welcome "+username +"city "+city;
	}
	
	//http://localhost:8080/userDetails/Avi/ayodhya
	@RequestMapping("/userDetails/{name}/{city}")  // data is attached to the url
	public String userDetails(@PathVariable("name")String username,@PathVariable("city")String city) {
		return "welcome "+username +"city "+city;
	}
	
}
