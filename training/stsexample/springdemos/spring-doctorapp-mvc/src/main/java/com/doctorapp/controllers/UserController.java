package com.doctorapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.doctorapp.model.Doctor;
import com.doctorapp.service.IDoctorService;


@Controller
public class UserController {
	
	@Autowired
	IDoctorService doctorService;
	
	@RequestMapping("/")
	public String home(Model model) {
		List<Doctor>doctorList=doctorService.allDoctors();
		model.addAttribute("doctorList", doctorList);
		return "home";
	}
	
	@RequestMapping("/addDoctorController")
	public String addDoctor(Doctor doctor,BindingResult result,Model model) {
		if(result.hasErrors()) {
			model.addAttribute("message","enter valid  input");
			return "addform";
		}
		doctorService.addDoctor(doctor);
		model.addAttribute("message","added successfully");
		return "admin";
	}
	
	@RequestMapping("/editDoctorController")
	public String editDoctor(@RequestParam("doctorId")int docterId,Model model) {
		Doctor doctor=doctorService.findById(docterId);
		model.addAttribute("doctor", doctor);
		return "updateform";
	}
	@RequestMapping("/updateDoctorController")
	public String updateDoctor(Doctor doctor,Model model) {
		int doctorId=doctor.getDoctorId();
		double fee=doctor.getFee();
		doctorService.updateDoctor(doctorId, fee);
		model.addAttribute("message","updated successfully");
		return "admin";
	}
	@RequestMapping("/deleteDoctorController")
	public String deleteDoctor(@RequestParam("doctorId")int doctrId,Model model) {
		doctorService.deleteDoctor(doctrId);
		model.addAttribute("message","deleted successfully");
		return "admin";
	}
	@RequestMapping("home")
	public String homePage(Model model) {
	
		return "redirect:/";
	}
	@RequestMapping("/search")
	public String searchDoctorBySpeciality(@RequestParam("searchName") String specialisation,Model model) {
		List<Doctor>doctorList=doctorService.findDoctorBySpeciality(specialisation);
		//System.out.println(doctorList);
		model.addAttribute("doctorList", doctorList);
		return "home";
	}
	@RequestMapping("/searchFee")
	public String searchDoctorByFee(@RequestParam("choice")double fee,Model model) {
		List<Doctor>doctorList=doctorService.findDoctorByFee(fee);
		//System.out.println(doctorList);
		model.addAttribute("doctorListFee", doctorList);
		return "home";
	}
}
