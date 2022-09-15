package com.doctorapp.service;

import java.util.List;

import com.doctorapp.exception.DoctorNotFoundException;
import com.doctorapp.model.Doctor;

public interface IDoctorService {

	// admin
	void addDoctor(Doctor doctor);

	void deleteDoctor(int doctorId);

	void updateDoctor(int doctorId, double fee);

	// user
	Doctor findById(int doctorId) throws DoctorNotFoundException;

	List<Doctor> allDoctors();

	List<Doctor> findDoctorBySpeciality(String specialisation) throws DoctorNotFoundException;

	List<Doctor> findDoctorByCityAndExperience(String city, int experience) throws DoctorNotFoundException;

	List<Doctor> findDoctorByExperience(int experience) throws DoctorNotFoundException;

	List<Doctor> findDoctorByFee(double fee) throws DoctorNotFoundException;
}
