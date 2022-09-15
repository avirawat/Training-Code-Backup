package com.doctorapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.doctorapp.exceptions.DoctorNotFoundException;
import com.doctorapp.exceptions.IdNotFoundException;
import com.doctorapp.model.Doctor;
import com.doctorapp.service.IDoctorService;

@RestController
@RequestMapping("doctor-service")
public class DoctorController {

	@Autowired
	IDoctorService doctorService;

	// http://localhost:8080/doctor-service/doctors
	@GetMapping("/doctors")
	List<Doctor> getAllDoctors() {
		return doctorService.getAllDoctors();
	}

	// http://localhost:8080/doctor-service/doctors/doctorId/100
	@GetMapping("/doctors/doctorId/{doctorId}")
	Doctor getById(@PathVariable("doctorId") int doctorId) throws IdNotFoundException {
		return doctorService.getById(doctorId);
	}

	@GetMapping("/doctors/name/{name}")
	List<Doctor> getByName(@PathVariable("name") String name) throws DoctorNotFoundException {
		return doctorService.getByName(name);
	}

	@GetMapping("/doctors/city/{city}")
	List<Doctor> getByCity(@PathVariable("city") String city) throws DoctorNotFoundException {
		return doctorService.getByCity(city);
	}

	@GetMapping("/doctors/rating/{rating}")
	List<Doctor> getByRating(@PathVariable("rating") double rating) throws DoctorNotFoundException {
		return doctorService.getByRating(rating);
	}

	@GetMapping("/doctors/experience/{experience}")
	List<Doctor> getByExperience(@PathVariable("experience") int experience) throws DoctorNotFoundException {
		return doctorService.getByExperience(experience);
	}

	@GetMapping("/doctors/fee/{fee}")
	List<Doctor> getByFeeLessThan(@PathVariable("fee") double fee) throws DoctorNotFoundException {
		return doctorService.getByFeeLessThan(fee);
	}

	@GetMapping("/doctors/cityName/{city}/exp/{experience}")
	List<Doctor> getByCityAndExperience(@PathVariable("city") String city, @PathVariable("experience") int experience)
			throws DoctorNotFoundException {
		return doctorService.getByCityAndExperience(city, experience);
	}

	// http://localhost:8080/doctor-service/doctors/cityName/Hyd/feeValue/1500
	@GetMapping("/doctors/cityName/{city}/feeValue/{fee}")
	List<Doctor> getByCityAndFee(@PathVariable("city") String city, @PathVariable("fee") double fee)
			throws DoctorNotFoundException {
		return doctorService.getByCityAndFee(city, fee);
	}

	// Doctor And Specialisation Table
	// http://localhost:8080/doctor-service/doctors/cityName/Hyd/speciality/Dentist
	@GetMapping("/doctors/cityName/{city}/speciality/{speciality}")
	List<Doctor> getByCityAndSpeciality(@PathVariable("city") String city,
			@PathVariable("speciality") String speciality) throws DoctorNotFoundException {
		return doctorService.getByCityAndSpeciality(city, speciality);
	}

	// http://localhost:8080/doctor-service/doctors/feeValue/1500/spl/Dentist
	@GetMapping("/doctors/feeValue/{fee}/spl/{speciality}")
	List<Doctor> getByFeeAndSpeciality(@PathVariable("fee") double fee, @PathVariable("speciality") String speciality)
			throws DoctorNotFoundException {
		return doctorService.getByFeeAndSpeciality(fee, speciality);
	}
}
