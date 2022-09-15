package com.doctorapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.doctorapp.exceptions.HospitalNotFoundException;
import com.doctorapp.model.Hospital;

@Service
public interface IHospitalService {
	//Hospital table
	List<Hospital> getAllHospitals();
	Hospital getById(int hospitalId) throws HospitalNotFoundException;
	List<Hospital> getByName(String name) throws HospitalNotFoundException;
	List<Hospital> getByRating(double rating) throws HospitalNotFoundException;
	List<Hospital> getBySpeciality(String speciality) throws HospitalNotFoundException;
	//Hospital And Doctor Table
	List<Hospital> getByDoctorName(String name) throws HospitalNotFoundException;
	List<Hospital> getByCityAndSpeciality(String city,String speciality) throws HospitalNotFoundException;
	List<Hospital> getByFeeAndSpeciality(double fee,String speciality) throws HospitalNotFoundException;
	List<Hospital> getByDoctorFee(double fee) throws HospitalNotFoundException;
}
