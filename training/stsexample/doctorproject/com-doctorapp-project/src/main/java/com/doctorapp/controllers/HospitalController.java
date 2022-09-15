package com.doctorapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.doctorapp.exceptions.HospitalNotFoundException;
import com.doctorapp.model.Hospital;
import com.doctorapp.service.IHospitalService;

@RestController
@RequestMapping("hospital-service")
public class HospitalController {

	@Autowired
	IHospitalService hospitalService;

	// http://localhost:8080/hospital-service/hospitals
	@GetMapping("/hospitals")
	List<Hospital> getAllDoctors() {
		return hospitalService.getAllHospitals();
	}

	// http://localhost:8080/hospital-service/hospitals/doctorName/Dr.Ayan
	@GetMapping("/hospitals/doctorName/{name}")
	List<Hospital> getByDoctorName(@PathVariable("name") String name) throws HospitalNotFoundException {
		return hospitalService.getByDoctorName(name);
	}

	// http://localhost:8080/hospital-service/hospitals/cityName/Hyd/speciality/orthopedist
	@GetMapping("/hospitals/cityName/{city}/speciality/{speciality}")
	List<Hospital> getByCityAndSpeciality(@PathVariable("city") String city,
			@PathVariable("speciality") String speciality) throws HospitalNotFoundException {
		return hospitalService.getByCityAndSpeciality(city, speciality);
	}

	// http://localhost:8080/hospital-service/hospitals/cityName/Hyd/speciality/orthopedist
	@GetMapping("/hospitals/feeValue/{fee}/spl/{speciality}")
	List<Hospital> getByFeeAndSpeciality(@PathVariable("fee") double fee, @PathVariable("speciality") String speciality)
			throws HospitalNotFoundException {
		return hospitalService.getByFeeAndSpeciality(fee, speciality);
	}
	//http://localhost:8080/hospital-service/hospitals/fee/1500
	@GetMapping("/hospitals/fee/{fee}")
	List<Hospital> getByDoctorFee(@PathVariable("fee") double fee) throws HospitalNotFoundException {
		return hospitalService.getByDoctorFee(fee);
	}
}
