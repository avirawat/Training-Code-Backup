package com.doctorapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.doctorapp.exceptions.DoctorNotFoundException;
import com.doctorapp.model.Doctor;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Integer> {

	//
	List<Doctor> findByName(String name) throws DoctorNotFoundException;

	List<Doctor> findByCity(String city) throws DoctorNotFoundException;

	List<Doctor> findByRating(double rating) throws DoctorNotFoundException;

	List<Doctor> findByExperience(int experience) throws DoctorNotFoundException;

	List<Doctor> findByFeeLessThan(double fee) throws DoctorNotFoundException;

	List<Doctor> findByCityAndExperience(String city, int experience) throws DoctorNotFoundException;

	List<Doctor> findByCityAndFee(String city, double fee) throws DoctorNotFoundException;

	// Table Doctor And Specialisation specialisation;
	@Query("From Doctor d inner join d.specialityList s where d.city=?1 and s.name=?2")
	List<Doctor> findByCityAndSpeciality(String city, String speciality) throws DoctorNotFoundException;

	@Query(value = "select * from Doctor d inner join specialisation s where d.fee<=?1 and s.name=?2", nativeQuery = true)
	List<Doctor> findByFeeAndSpeciality(double fee, String speciality) throws DoctorNotFoundException;
}
