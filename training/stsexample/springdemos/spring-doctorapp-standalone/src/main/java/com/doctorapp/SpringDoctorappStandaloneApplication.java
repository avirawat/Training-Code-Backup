package com.doctorapp;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.doctorapp.model.Doctor;
import com.doctorapp.service.IDoctorService;

@SpringBootApplication
public class SpringDoctorappStandaloneApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringDoctorappStandaloneApplication.class, args);
	}

	@Autowired
	IDoctorService doctorService;

	@Override
	public void run(String... args) throws Exception {
		Scanner sc = new Scanner(System.in);

		System.out.println(
				"Enter\n1. for add doctor\n2.delete doctor\n3.Update Fee\n4.All doctors\n5.Find doctor by Speciality\n6.Find doctor by city and experience"
						+ "\n7.find doctor By Experience\n8.Find doctor within your range\n0 For Exit()");
		int choice;
		do {
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				Doctor doctor = new Doctor(90, "Dr.Mukharji", "chennai", "physiotherepist", 20, 1000);
				doctorService.addDoctor(doctor);
				break;
			case 2:
				System.out.println("Enter doctorId to delete");
				int doctorId = sc.nextInt();
				doctorService.deleteDoctor(doctorId);
				break;
			case 3:
				System.out.println("Enter doctorId and Fee for update");
				int doctorid = sc.nextInt();
				double fee = sc.nextDouble();
				doctorService.updateDoctor(doctorid, fee);
				break;
			case 4:
				System.out.println("All Doctors");
				doctorService.allDoctors().forEach(System.out::println);
				break;
			case 5:
				System.out.println("Enter Speciality");
				String speciality=sc.next();
				try {
					doctorService.findDoctorBySpeciality(speciality).forEach(System.out::println);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			case 6:
				System.out.println("Enter city and experience");
				String city=sc.next();
				int exper=sc.nextInt();
				try {
					doctorService.findDoctorByCityAndExperience(city,exper).forEach(System.out::println);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			case 7:
				System.out.println("Enter Experience");
				int experience=sc.nextInt();
				try {
					doctorService.findDoctorByExperience(experience).forEach(System.out::println);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			case 8:
				System.out.println("Enter maximum Fee");
				double maximumFee=sc.nextDouble();
				try {
					doctorService.findDoctorByFee(maximumFee).forEach(System.out::println);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			case 0:
				System.exit(0);
			default:
				System.out.println("wrong choice");
			}

		} while (choice != 0);

	}

}
