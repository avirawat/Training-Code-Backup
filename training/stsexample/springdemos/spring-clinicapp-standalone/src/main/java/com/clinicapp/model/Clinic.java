package com.clinicapp.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@ToString
public class Clinic {
	
	
	private int clinicId;
	private String clinicName;
	private String city;
	private String clinicType;
	private double consultancyFee;
	
	public Clinic(int clinicId, String clinicName, String city, String clinicType, double consultancyFee) {
		super();
		this.clinicId = clinicId;
		this.clinicName = clinicName;
		this.city = city;
		this.clinicType = clinicType;
		this.consultancyFee = consultancyFee;
	}
	
	
}
