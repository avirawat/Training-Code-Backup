package com.shristi.basic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Employee {

	private String empName;
	private int empId;
	
	@Autowired
	private Address address;
	
	public String getEmpName() {
		return empName;
	}
	@Value("${employee.empName}")
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
	public void setAddress(Address address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Employee [empName=" + empName + ", empId=" + empId + ", address=" + address + "]";
	}
	
	
	
}
