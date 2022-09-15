package com.doctorapp.service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.doctorapp.exceptions.DoctorNotFoundException;
import com.doctorapp.exceptions.IdNotFoundException;
import com.doctorapp.model.Doctor;
import com.doctorapp.repository.DoctorRepository;

@Service
@Transactional
public class DoctorServiceImpl implements IDoctorService {

	@Autowired
	DoctorRepository doctorRepository;

	@Override
	public void addDoctor(Doctor doctor) {
		doctorRepository.save(doctor);

	}

	@Override
	public void deleteDoctor(int doctorId) {
		doctorRepository.deleteById(doctorId);

	}

	@Override
	public void updateDoctor(Doctor doctor) {
		doctorRepository.save(doctor);

	}

	@Override
	public Doctor getById(int doctorId) throws IdNotFoundException {
		Doctor doctorById = doctorRepository.findById(doctorId).get();
		if (doctorById == null) {
			throw new IdNotFoundException("Id not found");
		}
		return doctorById;

	}

	@Override
	public List<Doctor> getByName(String name) throws DoctorNotFoundException {
		List<Doctor> listByName = doctorRepository.findByName(name).stream()
				.sorted(Comparator.comparing(Doctor::getName)).collect(Collectors.toList());
		if (listByName.isEmpty()) {
			throw new DoctorNotFoundException("Doctor not found");
		}
		return listByName;
	}

	@Override
	public List<Doctor> getByCity(String city) throws DoctorNotFoundException {
		List<Doctor> listByCity = doctorRepository.findByCity(city).stream()
				.sorted(Comparator.comparing(Doctor::getName)).collect(Collectors.toList());
		if (listByCity.isEmpty()) {
			throw new DoctorNotFoundException("Doctor not found");
		}
		return listByCity;
	}

	@Override
	public List<Doctor> getByRating(double rating) throws DoctorNotFoundException {
		List<Doctor> listByRating = doctorRepository.findByRating(rating).stream()
				.sorted(Comparator.comparing(Doctor::getName)).collect(Collectors.toList());
		if (listByRating.isEmpty()) {
			throw new DoctorNotFoundException("Doctor not found");
		}
		return listByRating;
	}

	@Override
	public List<Doctor> getByExperience(int experience) throws DoctorNotFoundException {
		List<Doctor> listByExperience = doctorRepository.findByExperience(experience).stream()
				.sorted(Comparator.comparing(Doctor::getName)).collect(Collectors.toList());
		if (listByExperience.isEmpty()) {
			throw new DoctorNotFoundException("Doctor not found");
		}
		return listByExperience;
	}

	@Override
	public List<Doctor> getByFeeLessThan(double fee) throws DoctorNotFoundException {
		List<Doctor> listByFee = doctorRepository.findByFeeLessThan(fee).stream()
				.sorted(Comparator.comparing(Doctor::getName)).collect(Collectors.toList());
		if (listByFee.isEmpty()) {
			throw new DoctorNotFoundException("Doctor not found");
		}
		return listByFee;
	}

	@Override
	public List<Doctor> getByCityAndExperience(String city, int experience) throws DoctorNotFoundException {
		List<Doctor> listByCityAndExperience = doctorRepository.findByCityAndExperience(city, experience).stream()
				.sorted(Comparator.comparing(Doctor::getName)).collect(Collectors.toList());
		if (listByCityAndExperience.isEmpty()) {
			throw new DoctorNotFoundException("Doctor not found");
		}
		return listByCityAndExperience;
	}

	@Override
	public List<Doctor> getByCityAndFee(String city, double fee) throws DoctorNotFoundException {
		List<Doctor> listByCityAndFee = doctorRepository.findByCityAndFee(city, fee).stream()
				.sorted(Comparator.comparing(Doctor::getName)).collect(Collectors.toList());
		if (listByCityAndFee.isEmpty()) {
			throw new DoctorNotFoundException("Doctor not found");
		}
		return listByCityAndFee;
	}

	@Override
	public List<Doctor> getByCityAndSpeciality(String city, String speciality) throws DoctorNotFoundException {
		return doctorRepository.findByCityAndSpeciality(city, speciality);
	}

	@Override
	public List<Doctor> getByFeeAndSpeciality(double fee, String speciality) throws DoctorNotFoundException {
		return doctorRepository.findByFeeAndSpeciality(fee, speciality);
	}

	@Override
	public List<Doctor> getAllDoctors() {
		return doctorRepository.findAll();
	}

	

}
