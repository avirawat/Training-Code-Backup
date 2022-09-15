package com.doctorapp.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

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

public class Doctor {
	
	@Id
	@GeneratedValue(generator = "doctor_id",strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "doctor_id",sequenceName = "doctor_seq",initialValue = 100,allocationSize = 1)
	private Integer doctorId;
	
	@Column(length = 20)
	private String name;
	
	@Column(length = 20)
	private String city;
	
	private double rating;
	private Integer experience;
	private double fee;
	

	@ManyToMany(cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
	@JoinTable(name="doctor_speciality",
				joinColumns = @JoinColumn(name="doctor_id"),
				inverseJoinColumns = @JoinColumn(name="spl_id"))
	@JsonIgnore
	private Set<Specialisation> specialityList;
	
	
	@ManyToMany(cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
	@JoinTable(name="doctor_hospital",
		joinColumns = @JoinColumn(name="doctor_id"),
		inverseJoinColumns = @JoinColumn(name="hospital_id"))
	@JsonIgnore
	private Set<Hospital> hospitalList;
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name="doctor_id")
	@JsonIgnore
	private Set<Consultation> consultancyList;

	public Doctor(String name, String city, double rating, Integer experience, double fee,
			Set<Specialisation> specialityList, Set<Hospital> hospitalList, Set<Consultation> consultancyList) {
		super();
		this.name = name;
		this.city = city;
		this.rating = rating;
		this.experience = experience;
		this.fee = fee;
		this.specialityList = specialityList;
		this.hospitalList = hospitalList;
		this.consultancyList = consultancyList;
	}

	@Override
	public String toString() {
		return "Doctor [name=" + name + ", city=" + city + ", rating=" + rating + ", experience=" + experience
				+ ", fee=" + fee + ", specialityList=" + specialityList + ", hospitalList=" + hospitalList
				+ ", consultancyList=" + consultancyList + "]";
	}

	
	
	
}
