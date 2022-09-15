package com.doctorapp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Doctor {

	private Integer doctorId;
	private String doctorName;
	private String city;
	private String specialisation;
	private Integer experience;
	private Double fee;
	
	public Doctor(Integer doctorId, String doctorName, String city, String specialisation, Integer experience,
			Double fee) {
		super();
		this.doctorId = doctorId;
		this.doctorName = doctorName;
		this.city = city;
		this.specialisation = specialisation;
		this.experience = experience;
		this.fee = fee;
	}

	

}
