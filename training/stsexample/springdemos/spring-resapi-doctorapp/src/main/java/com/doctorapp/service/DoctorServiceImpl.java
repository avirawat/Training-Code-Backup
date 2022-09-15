package com.doctorapp.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.doctorapp.model.Doctor;


@Service
public class DoctorServiceImpl implements IDoctorService {

	@Override
	public Doctor findById(int doctorId) {
		return showDoctors()
				.stream()
				.filter((product)->product.getDoctorId()==doctorId).findAny().get();
	}

	@Override
	public List<Doctor> allDoctors() {
		return showDoctors();
	}

	@Override
	public List<Doctor> findDoctorBySpeciality(String specialisation)  {
		return showDoctors()
				.stream()
				.filter((product)->product.getSpecialisation().equals(specialisation))
				.collect(Collectors.toList());
	}

	@Override
	public List<Doctor> findDoctorByExperience(int experience) {
		return showDoctors()
				.stream()
				.filter((product)->product.getExperience().equals(experience))
				.collect(Collectors.toList());
	}

	@Override
	public List<Doctor> findDoctorByFee(double fee)  {
		return showDoctors()
				.stream()
				.filter((product)->product.getFee()<=fee)
				.collect(Collectors.toList());
	}
	@Override
	public List<Doctor> findDoctorByCityAndExperience(String city, int experience) {
		return showDoctors()
				.stream()
				.filter((product)->product.getCity().equals(city) && product.getExperience()<=experience)
				.collect(Collectors.toList());
	}
	
	private List<Doctor> showDoctors() {
		return Arrays.asList(
				new Doctor(100,"Dr.Ayan","sagar","dentist",10,800.0),
				new Doctor(101,"Dr.Avi","ayodhya","surgeon",15,1800.0),
				new Doctor(102,"Dr.sharma","blg","physician",20,2000.0),
				new Doctor(103,"Dr.gupta","hyd","surgeon",8,800.0),
				new Doctor(104,"Dr.kumar","chennai","dentist",12,1100.0)
				);
				
	}

	

}
