package com.security.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.security.model.AppUsers;
import com.security.service.AppUsersServiceImpl;

@RestController
public class SecureProductController {
	
	private PasswordEncoder encoder;
	
	@Autowired
	private AppUsersServiceImpl appUsersServiceImpl;
	
	@Autowired
	public void setEncoder(PasswordEncoder encoder) {
		this.encoder = encoder;
	}
	public PasswordEncoder getEncoder() {
		return encoder;
	}


	@GetMapping("/")
	public String greet() {
		AppUsers user=new AppUsers();
		user.setUsername("avinash");
		user.setPassword(getEncoder().encode("avi123"));
		user.setEmail("avirawat1048@gmail.com");
		//appUsersServiceImpl.addUser(user);
		return "welcome to ProductApp";
	}
	



	@GetMapping("/admin/add")
	public String addProduct() {
		return "product Added";
	}
	
	@GetMapping("/admin/update")
	public String updateProduct() {
		return "product upadted";
	}
	
	@GetMapping("/products/show")
	public String showProducts() {
		return "List Of Products";
	}
	
	@GetMapping("/products/id/{productId}")
	public String getById(@PathVariable("productId")int productId) {
		return "Product By id";
	}
	
	
}
