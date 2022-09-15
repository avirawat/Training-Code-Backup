package com.doctorapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {

	@RequestMapping("/admin")
	public String adminPage() {
		return "admin";
	}

	@RequestMapping("/addDoctor")
	public String addDoctor() {
		return "addform";
	}
	@RequestMapping("/editDoctor")
	public String editDoctor() {
		return "editform";
	}

	@RequestMapping("/deleteDoctor")
	public String deleteDoctor() {
		return "deleteform";
	}
}
