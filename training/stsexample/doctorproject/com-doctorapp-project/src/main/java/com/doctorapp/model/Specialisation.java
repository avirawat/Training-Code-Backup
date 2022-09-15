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

public class Specialisation {
	
	@Id
	@GeneratedValue(generator = "sp_id",strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "sp_id",sequenceName = "sp_seq",initialValue = 100,allocationSize = 1)
	
	private Integer splId;
	@Column(length=20)
	private String sname;
	
	@ManyToMany(mappedBy = "specialityList",fetch = FetchType.EAGER)
	Set<Doctor> doctorList=new HashSet<>();
	
	public Specialisation(String name) {
		super();
		this.sname = name;
	}

	@Override
	public String toString() {
		return "Specialisation [name=" + sname + "]";
	}
	
}
