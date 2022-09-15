package com.employeeapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employeeapp.model.Employee;
import com.employeeapp.repository.IEmployeeRepository;

@Service
public class EmployeeServiceImpl implements IEmployeeService{

	@Autowired
	IEmployeeRepository employeeRepository;
	
	
	public void setEmployeeRepository(IEmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	@Override
	public Employee addEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public void updateEmployee(Employee employee) {
		 employeeRepository.save(employee);
		
	}

	@Override
	public void deleteEmployee(int employeeId) {
		employeeRepository.deleteById(employeeId);
		
	}

	@Override
	public List<Employee> getAll() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee getById(int employeeId) {
		Optional<Employee>optEmployee=employeeRepository.findById(employeeId);
		return optEmployee.get();
	}

	@Override
	public List<Employee> getByDesig(String designation) {
		return employeeRepository.findByDesignation(designation);
	}

	@Override
	public List<Employee> getByCity(String city) {
		//return employeeRepository.findByAddressCity(city);
		return employeeRepository.findByCity(city);
	}

	@Override
	public List<Employee> getByCityAndDesig(String city, String designation) {
		return employeeRepository.findByCityAndDesignation(city, designation);
	}

	@Override
	public List<Employee> getByAddressCity(String city) {
		return employeeRepository.findByCity(city);
	}

	@Override
	public List<Employee> getBySalaryCity(double salary, String city) {
		return employeeRepository.findByLessSalaryCity(salary, city);
	}

//	@Override
//	public List<Employee> getByCityAndSalary(String city, double salary) {
//		return employeeRepository.findByCityAndSalary(city, salary);
//	}

	

}
