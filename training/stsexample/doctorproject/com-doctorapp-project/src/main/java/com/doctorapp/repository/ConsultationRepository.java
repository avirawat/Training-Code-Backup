package com.doctorapp.repository;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.doctorapp.exceptions.DoctorNotFoundException;
import com.doctorapp.model.Consultation;

@Repository
public interface ConsultationRepository extends JpaRepository<Consultation,Integer> {
	
	//boolean findByDate(LocalDate date) throws DoctorNotFoundException;
}
