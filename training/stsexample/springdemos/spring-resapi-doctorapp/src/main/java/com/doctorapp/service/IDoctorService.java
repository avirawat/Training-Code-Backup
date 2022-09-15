package com.doctorapp.service;

import java.util.List;


import com.doctorapp.model.Doctor;

public interface IDoctorService {


	Doctor findById(int doctorId);

	List<Doctor> allDoctors();

	List<Doctor> findDoctorBySpeciality(String specialisation);

	List<Doctor> findDoctorByExperience(int experience);

	List<Doctor> findDoctorByFee(double fee) ;
	
	List<Doctor> findDoctorByCityAndExperience(String city, int experience) ;
}
