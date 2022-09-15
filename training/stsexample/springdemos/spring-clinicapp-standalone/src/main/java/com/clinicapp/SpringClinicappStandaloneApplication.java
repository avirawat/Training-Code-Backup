package com.clinicapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.clinicapp.Repository.IClinicRepository;
import com.clinicapp.model.Clinic;

@SpringBootApplication
public class SpringClinicappStandaloneApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringClinicappStandaloneApplication.class, args);
	}

	@Autowired
	IClinicRepository clinicRepository;
	
	@Override
	public void run(String... args) throws Exception {
		//Admin Part
		
		//Clinic clinic=new Clinic(20,"teja","TN","physiology",800);
		//clinicRepository.addClinic(clinic);
		//clinicRepository.deleteClinic(12);
		//clinicRepository.updateClinic(20, 1200);
		
		//user
		
		clinicRepository.getAllClinic().forEach(System.out::println);
		clinicRepository.getClinicByName("Ayan").forEach(System.out::println);
		clinicRepository.getClinicByCity("Ayodhya").forEach(System.out::println);
		clinicRepository.getClinicByFee(500).forEach(System.out::println);
		clinicRepository.getClinicByTyppe("physiology").forEach(System.out::println);
	}

}
