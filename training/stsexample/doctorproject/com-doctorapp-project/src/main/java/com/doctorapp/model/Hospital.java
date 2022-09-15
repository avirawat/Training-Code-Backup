package com.doctorapp.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Hospital {
	
	@Id
	@GeneratedValue(generator = "hospital_id",strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "hospital_id",sequenceName = "hospital_seq",initialValue = 100,allocationSize = 1)
	private Integer hospitalId;
	@Column(length=20)
	private String name;
	@Column(length=20)
	private String speciality;
	private double rating;
	
	@ManyToMany(mappedBy = "hospitalList",fetch = FetchType.EAGER)
	@JsonIgnore
	private Set<Doctor> doctorList;

	public Hospital(String name, String speciality, double rating) {
		super();
		this.name = name;
		this.speciality = speciality;
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "Hospital [name=" + name + ", speciality=" + speciality + ", rating=" + rating + "]";
	}
	
}
