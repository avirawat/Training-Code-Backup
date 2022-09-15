package com.shristi.basic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:application.properties")
public class Employee {
	
	private String empName;
	private int empId;
	private Address address;
	
	
	public String getEmpName() {
		return empName;
	}
	@Value("${employee.empName}") //expression language get value from 
					//application propewrties
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public int getEmpId() {
		return empId;
	}
	@Value("${employee.empId}")
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public Address getAddress() {
		return address;
	}
	@Autowired
	public void setAddress(Address address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Employee [empName=" + empName + ", empId=" + empId + ", address=" + address + "]";
	}
	
	
	
	
	
	
}
