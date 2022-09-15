package com.clinicapp.Repository;

import java.util.List;

import com.clinicapp.exceptions.ClinicNotFoundException;
import com.clinicapp.model.Clinic;

public interface IClinicRepository {
	
	//admin
	void addClinic(Clinic clinic);
	void deleteClinic(int clinicId) throws ClinicNotFoundException;
	void updateClinic(int clinicId,double consultancyFee) throws ClinicNotFoundException;
	
	//user
	
	List<Clinic> getAllClinic();
	List<Clinic> getClinicByName(String clinicName) throws ClinicNotFoundException;
	List<Clinic> getClinicByCity(String clinicCity) throws ClinicNotFoundException;
	List<Clinic> getClinicByTyppe(String clinicType) throws ClinicNotFoundException;
	List<Clinic> getClinicByFee(double consultancyFee) throws ClinicNotFoundException;
	
}
