package com.employeeapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.employeeapp.service.IAddressService;
import com.employeeapp.service.IEmployeeService;

@SpringBootApplication
public class SpringOnetooneDatajpaApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(SpringOnetooneDatajpaApplication.class, args);
	}
	
	@Autowired
	IEmployeeService employeeService;
	
	@Autowired
	IAddressService addressService;

	@Override
	public void run(String... args) throws Exception {
	
//		System.out.println("-------Add Employee-----");
		
//		Address address=new Address("Ayodhya","UP");
//		Employee employee=new Employee("Avi","Manager",50000,address);
//		employeeService.addEmployee(employee);
//		
//		System.out.println("-------All Details OF Employee-----");
//		employeeService.getAll().forEach(System.out::println);
//		
//		System.out.println("-------Find By Id-----");
//		System.out.println(employeeService.getById(1));
//		
//		System.out.println("-------Employee Details By Designation-----");
//		employeeService.getByDesig("Manager").forEach(System.out::println);
//		
//		System.out.println("-------Employee Details By City-----");
//		employeeService.getByCity("Banglore").forEach(System.out::println);
//		//custom
//		System.out.println("-------Employee Details By City And designation By custom-----");
//		employeeService.getByCityAndDesig("Banglore","tech-lead").forEach(System.out::println);
//		
//		System.out.println("-------Employee Details By City custome Query-----");
//		employeeService.getByAddressCity("Banglore").forEach(System.out::println);
//		//Named Query
//		System.out.println("-------Employee Details By Salary And City Named Query-----");
//		employeeService.getBySalaryCity(50000,"Banglore").forEach(System.out::println);
//			
		System.out.println("-------Get Details By EMployee Name-----");
		System.out.println(addressService.getByEmployeeName("sam"));
		

		
	}

}
