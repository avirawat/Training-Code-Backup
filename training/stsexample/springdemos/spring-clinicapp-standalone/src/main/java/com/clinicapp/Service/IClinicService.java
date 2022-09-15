package com.clinicapp.Service;

import java.util.List;

import com.clinicapp.exceptions.ClinicNotFoundException;
import com.clinicapp.model.Clinic;

public interface IClinicService {
	
	//admin
	void addClinic(Clinic clinic);
	void deleteClinic(int clinicId) throws ClinicNotFoundException;
	void updateClinic(int clinicId,double consultancyFee) throws ClinicNotFoundException;
	
	//user
	
	List<Clinic> findAllClinic();
	List<Clinic> findClinicByName(String clinicName) throws ClinicNotFoundException;
	List<Clinic> findClinicByCity(String clinicCity) throws ClinicNotFoundException;
	List<Clinic> findClinicByTyppe(String clinicType) throws ClinicNotFoundException;
	List<Clinic> findClinicByFee(double consultancyFee) throws ClinicNotFoundException;
	
}
