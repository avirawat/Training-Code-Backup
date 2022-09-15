package com.doctorapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doctorapp.exception.DoctorNotFoundException;
import com.doctorapp.model.Doctor;
import com.doctorapp.repository.IDoctorRepository;

@Service
public class DoctorServiceImpl implements IDoctorService {

	@Autowired
	IDoctorRepository doctorRepository;

	public void setDoctorRepository(IDoctorRepository doctorRepository) {
		this.doctorRepository = doctorRepository;
	}

	@Override
	public void addDoctor(Doctor doctor) {
		doctorRepository.addDoctor(doctor);

	}

	@Override
	public void deleteDoctor(int doctorId) {
		doctorRepository.deleteDoctor(doctorId);

	}

	@Override
	public void updateDoctor(int doctorId, double fee) {
		doctorRepository.updateDoctor(doctorId, fee);

	}

	@Override
	public List<Doctor> allDoctors() {

		return doctorRepository.allDoctors();
	}

	@Override
	public List<Doctor> findDoctorBySpeciality(String specialisation) throws DoctorNotFoundException {
		List<Doctor> doctorBySpeciality = doctorRepository.getDoctorBySpeciality(specialisation);
		if (doctorBySpeciality.isEmpty()) {
			throw new DoctorNotFoundException("No doctor found with this Specialisation");
		}
		return doctorBySpeciality;
	}

	@Override
	public List<Doctor> findDoctorByCityAndExperience(String city, int experience) throws DoctorNotFoundException {
		List<Doctor> doctorByCityAndExperience = doctorRepository.getDoctorByCityAndExperience(city, experience);
		if (doctorByCityAndExperience.isEmpty()) {
			throw new DoctorNotFoundException("No doctor found in thic city with this experince");
		}
		return doctorByCityAndExperience;
	}

	@Override
	public List<Doctor> findDoctorByExperience(int experience) throws DoctorNotFoundException {
		List<Doctor> doctorByExperience = doctorRepository.getDoctorByExperience(experience);
		if (doctorByExperience.isEmpty()) {
			throw new DoctorNotFoundException("No doctor found with this experince");
		}
		return doctorByExperience;
	}

	@Override
	public List<Doctor> findDoctorByFee(double fee) throws DoctorNotFoundException {
		List<Doctor> doctorByFee = doctorRepository.getDoctorByFee(fee);
		if (doctorByFee.isEmpty()) {
			throw new DoctorNotFoundException("No doctor found within this price");
		}
		return doctorByFee;
	}

}
