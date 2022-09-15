package com.doctorapp.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.doctorapp.exceptions.DoctorNotFoundException;
import com.doctorapp.model.Doctor;

@Service
public interface IConsultationService {
	
	//List<Doctor> getDoctorByDate(LocalDate date) throws DoctorNotFoundException;
}
