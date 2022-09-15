package com.employeeapp.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity

@NamedQuery(name="findbySalCity",
			query="from Employee e inner join e.address a where e.salary<=?1 and a.city=?2")
public class Employee {
	@Id
	@GeneratedValue(generator="employee_gen",strategy=GenerationType.AUTO)
	@SequenceGenerator(name="employee_gen",sequenceName = "employee_seq",initialValue = 1,allocationSize = 1)  
	private Integer employeeId;
	private String name;
	private String designation;
	private double salary;
	
	@OneToOne(cascade=CascadeType.ALL)  // save the address object before saving employee
	@JoinColumn(name="address_id")
	Address address;

	public Employee(String name, String designation, double salary, Address address) {
		super();
		this.name = name;
		this.designation = designation;
		this.salary = salary;
		this.address = address;
	}
	
	
}
