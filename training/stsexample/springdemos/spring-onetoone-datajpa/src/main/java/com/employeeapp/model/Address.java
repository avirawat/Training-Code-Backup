package com.employeeapp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
public class Address {
	@Id
	@GeneratedValue(generator="address_gen",strategy=GenerationType.AUTO)
	@SequenceGenerator(name="address_gen",sequenceName = "address_seq",initialValue = 1,allocationSize = 1)  
	private Integer addressId;
	private String city;
	private String state;
	
	@OneToOne(mappedBy = "address")  // address fiels is owner of this relationship
	private Employee employee;
	public Address(String city, String state) {
		super();
		this.city = city;
		this.state = state;
	}
	@Override
	public String toString() {
		return "Address [city=" + city + ", state=" + state + "]";
	}
	
	
}
