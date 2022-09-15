package com.doctorapp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.doctorapp.model.Consultation;
import com.doctorapp.model.Doctor;
import com.doctorapp.model.Hospital;
import com.doctorapp.model.Specialisation;
import com.doctorapp.service.IDoctorService;
import com.doctorapp.service.IHospitalService;


@SpringBootConfiguration
@EnableAutoConfiguration
@SpringBootApplication
public class ComDoctorappProjectApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ComDoctorappProjectApplication.class, args);
	}

	@Autowired
	IDoctorService doctorService;
	
	@Autowired
	IHospitalService hospitalService;

	@Override
	public void run(String... args) throws Exception {
		
		//adding value
		//Specialisation
//		Specialisation s1=new Specialisation("Dietition");
//		Specialisation s2=new Specialisation("Nutrition");
//		Set<Specialisation> specialityList=new HashSet<>(Arrays.asList(s1,s2));
//		//hospital
//		Hospital hospital1=new Hospital("MotherhoodHospital","Pediatrician",4.1);
//		Hospital hospital2=new Hospital("Manipal","orthopedist",4.5);
//		Set<Hospital> hospitalList=new HashSet<>(Arrays.asList(hospital1,hospital2));
//		//Consulatation Time
//		LocalDate dateInstance=LocalDate.of(2021,9,29);
//		LocalTime timeInstance=LocalTime.of(9,45);
//		LocalDateTime startTime=LocalDateTime.of(dateInstance,timeInstance);
//		LocalDate date=LocalDate.of(2021,9,29);
//		LocalTime time=LocalTime.of(16,45);
//		LocalDateTime endTime=LocalDateTime.of(date,time);
//		Consultation consultancyPeriod1=new Consultation(dateInstance,"available", startTime, endTime);
//		Set<Consultation> consultancyList=new HashSet<>(Arrays.asList(consultancyPeriod1));
//		Doctor doctor=new Doctor("Dr.Ayan","Blg",4.5,10,1200.0,specialityList,hospitalList,consultancyList);
//		doctorService.addDoctor(doctor);
		
		Specialisation s1=new Specialisation("Dentist");
		Specialisation s2=new Specialisation("physician");
		Set<Specialisation> specialityList=new HashSet<>(Arrays.asList(s1,s2));
		//hospital
		Hospital hospital1=new Hospital("Apollo","surgeon",4.2);
		Hospital hospital2=new Hospital("Sahara","orthopedist",4.6);
		Set<Hospital> hospitalList=new HashSet<>(Arrays.asList(hospital1,hospital2));
		//Consulatation Time
		LocalDate dateInstance=LocalDate.of(2021,9,28);
		LocalTime timeInstance=LocalTime.of(10,45);
		LocalDateTime startTime=LocalDateTime.of(dateInstance,timeInstance);
		LocalDate date=LocalDate.of(2021,9,28);
		LocalTime time=LocalTime.of(14,30);
		LocalDateTime endTime=LocalDateTime.of(date,time);
		Consultation consultancyPeriod1=new Consultation(dateInstance,"available", startTime, endTime);
		Set<Consultation> consultancyList=new HashSet<>(Arrays.asList(consultancyPeriod1));
		Doctor doctor=new Doctor("Dr.Teja","Hyd",4.6,15,1500.0,specialityList,hospitalList,consultancyList);
		//doctorService.addDoctor(doctor);
		//Doctor
		System.out.println("******************Find ALl Doctors********************");
		doctorService.getAllDoctors().forEach(System.out::println);
		System.out.println("******************Get By ID********************");
		System.out.println(doctorService.getById(100));
		System.out.println("******************Get By Name********************");
		doctorService.getByName("Dr.Teja").forEach(System.out::println);
		System.out.println("******************Get By City********************");
		doctorService.getByCity("Hyd").forEach(System.out::println);
		System.out.println("******************Get By Rating********************");
		doctorService.getByRating(4.5).forEach(System.out::println);
		System.out.println("******************Get By Experience********************");
		doctorService.getByExperience(10).forEach(System.out::println);
		System.out.println("******************Get By Fee********************");
		doctorService.getByFeeLessThan(1500).forEach(System.out::println);
		System.out.println("******************Get By City And Experience********************");
		doctorService.getByCityAndExperience("Hyd", 15).forEach(System.out::println);
		System.out.println("******************Get By City And Fee********************");
		doctorService.getByCityAndFee("Hyd", 1500).forEach(System.out::println);
		System.out.println("******************Get By City And Speciality********************");
		doctorService.getByCityAndSpeciality("Hyd","physician").forEach(System.out::println);
		System.out.println("******************Get By Fee And Speciality********************");
		doctorService.getByFeeAndSpeciality(2000,"physician").forEach(System.out::println);
		//Hospital hospitalService
		System.out.println("******************Get All Hospital By DoctorName********************");
		hospitalService.getByDoctorName("Dr.Ayan").forEach(System.out::println);
	}

}
