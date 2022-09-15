package com.doctorapp.model;

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
	private int experience;
	private double fee;

	public Doctor(Integer doctorId, String doctorName, String city, String specialisation, int experience, double fee) {
		super();
		this.doctorId = doctorId;
		this.doctorName = doctorName;
		this.city = city;
		this.specialisation = specialisation;
		this.experience = experience;
		this.fee = fee;
	}

}
