package com.doctorapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.doctorapp.model.Doctor;
import com.doctorapp.service.IDoctorService;

@RestController
@RequestMapping("doctors-api")
public class DoctorController {

	@Autowired
	IDoctorService doctorService;

	@GetMapping("/doctors/{doctorId}")
	public Doctor findById(int doctorId) {
		return doctorService.findById(doctorId);
	}

	@GetMapping("/doctors")
	public List<Doctor> allDoctors() {
		return doctorService.allDoctors();
	}

	@GetMapping("/doctors/{specialisation}")
	public List<Doctor> findDoctorBySpeciality(String specialisation) {
		return doctorService.findDoctorBySpeciality(specialisation);
	}

	@GetMapping("/doctors/{experience}")
	public List<Doctor> findDoctorByExperience(int experience) {
		return doctorService.findDoctorByExperience(experience);
	}

	@GetMapping("/doctors/{fee}")
	public List<Doctor> findDoctorByFee(double fee) {
		return doctorService.findDoctorByFee(fee);
	}
	@GetMapping("/doctors/city/{city}/experience/{experience}")
	public List<Doctor> findDoctorByCityAndExperience(String city, int experience) {
		return doctorService.findDoctorByCityAndExperience(city, experience);
	}
}
