package com.clinicapp.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clinicapp.Repository.IClinicRepository;
import com.clinicapp.exceptions.ClinicNotFoundException;
import com.clinicapp.model.Clinic;

@Service
public class ClinicServiceImpl implements IClinicService {
	
	@Autowired
	IClinicRepository clinicRepository;
	
	
	public void setClinicRepository(IClinicRepository clinicRepository) {
		this.clinicRepository = clinicRepository;
	}

	@Override
	public void addClinic(Clinic clinic) {
		clinicRepository.addClinic(clinic);
		
	}

	@Override
	public void deleteClinic(int clinicId) throws ClinicNotFoundException {
		clinicRepository.deleteClinic(clinicId);
		
	}

	@Override
	public void updateClinic(int clinicId, double consultancyFee) throws ClinicNotFoundException {
		clinicRepository.updateClinic(clinicId, consultancyFee);
		
	}

	@Override
	public List<Clinic> findAllClinic() {
		return clinicRepository.getAllClinic();
	}

	@Override
	public List<Clinic> findClinicByName(String clinicName) throws ClinicNotFoundException {
		List<Clinic> clinicsByName=clinicRepository.getClinicByName(clinicName);
		if(clinicsByName.isEmpty()) {
			throw new ClinicNotFoundException("Name not found");
		}
		return clinicsByName;
	}

	@Override
	public List<Clinic> findClinicByCity(String clinicCity) throws ClinicNotFoundException {
		List<Clinic> clinicsByCity=clinicRepository.getClinicByCity(clinicCity);
		if(clinicsByCity.isEmpty()) {
			throw new ClinicNotFoundException("City not found");
		}
		return clinicsByCity;
	}

	@Override
	public List<Clinic> findClinicByTyppe(String clinicType) throws ClinicNotFoundException {
		List<Clinic> clinicsByType=clinicRepository.getClinicByTyppe(clinicType);
		if(clinicsByType.isEmpty()) {
			throw new ClinicNotFoundException("Clinic not found");
		}
		return clinicsByType;
	}

	@Override
	public List<Clinic> findClinicByFee(double consultancyFee) throws ClinicNotFoundException {
		List<Clinic> clinicsByFee=clinicRepository.getClinicByFee(consultancyFee);
		if(clinicsByFee.isEmpty()) {
			throw new ClinicNotFoundException("Clinic not found");
		}
		return clinicsByFee;
	}

	
}
