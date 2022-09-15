package com.doctorapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doctorapp.exceptions.HospitalNotFoundException;
import com.doctorapp.model.Hospital;
import com.doctorapp.repository.HospitalRepository;

@Service
public class HospitalServiceImpl implements IHospitalService {

	@Autowired
	HospitalRepository hospitalRepository;

	public List<Hospital> getAllHospitals() {
		return hospitalRepository.findAll();
	}

	@Override
	public Hospital getById(int hospitalId) throws HospitalNotFoundException {
		return hospitalRepository.findById(hospitalId).get();
	}

	@Override
	public List<Hospital> getByName(String name) throws HospitalNotFoundException {
		return hospitalRepository.findByName(name);
	}

	@Override
	public List<Hospital> getByRating(double rating) throws HospitalNotFoundException {
		return hospitalRepository.findByRating(rating);
	}

	@Override
	public List<Hospital> getBySpeciality(String speciality) throws HospitalNotFoundException {
		return hospitalRepository.findBySpeciality(speciality);
	}

	@Override
	public List<Hospital> getByDoctorName(String name) throws HospitalNotFoundException {
		return hospitalRepository.findByDoctorName(name);
	}

	@Override
	public List<Hospital> getByCityAndSpeciality(String city, String speciality) throws HospitalNotFoundException {
		return hospitalRepository.findByCityAndSpeciality(city, speciality);
	}

	@Override
	public List<Hospital> getByFeeAndSpeciality(double fee, String speciality) throws HospitalNotFoundException {
		return hospitalRepository.findByFeeAndSpeciality(fee, speciality);
	
	}

	@Override
	public List<Hospital> getByDoctorFee(double fee) throws HospitalNotFoundException {
		return hospitalRepository.findByDoctorFee(fee);
	}

}
