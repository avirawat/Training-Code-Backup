package com.doctorapp.repository;

import java.util.List;

import com.doctorapp.exception.DoctorNotFoundException;
import com.doctorapp.model.Doctor;

public interface IDoctorRepository {

	// admin
	void addDoctor(Doctor doctor);

	void deleteDoctor(int doctorId);

	void updateDoctor(int doctorId, double fee);

	// user

	List<Doctor> allDoctors();

	List<Doctor> getDoctorBySpeciality(String specialisation) throws DoctorNotFoundException;

	List<Doctor> getDoctorByCityAndExperience(String city, int experience) throws DoctorNotFoundException;

	List<Doctor> getDoctorByExperience(int experience) throws DoctorNotFoundException;

	List<Doctor> getDoctorByFee(double fee) throws DoctorNotFoundException;
}
