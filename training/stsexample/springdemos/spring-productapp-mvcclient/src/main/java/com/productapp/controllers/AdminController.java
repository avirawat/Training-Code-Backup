package com.productapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {
	
	@RequestMapping("/admin")
	public String adminPage() {
		
		return "admin";
	}
	
	@RequestMapping("/addform")
	public String addProductForm() {
		  
		return "addform";       // name of the jsp page
	}
	
	@RequestMapping("/editform")
	public String editProductForm() {
		  
		return "editform";       // name of the jsp page
	}
	@RequestMapping("/deleteform")
	public String deleteProductForm() {
		  
		return "deleteform";       // name of the jsp page
	}
}
