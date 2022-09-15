package com.employeeapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.employeeapp.model.Employee;

@Service
public interface IEmployeeService {
	
	Employee addEmployee(Employee employee);
	void updateEmployee(Employee employee);
	void deleteEmployee(int employeeId);
	
	List<Employee> getAll();
	Employee getById(int employeeId);
	List<Employee> getByDesig(String designation);
	List<Employee> getByCity(String city);
	//custom
	List<Employee> getByCityAndDesig(String city,String designation);
	List<Employee> getByAddressCity(String city);
	
	//named Query
	List<Employee> getBySalaryCity(double salary,String city);
}
