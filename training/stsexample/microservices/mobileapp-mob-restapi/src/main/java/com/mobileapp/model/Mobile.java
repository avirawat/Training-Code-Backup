package com.mobileapp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
public class Mobile {
	
	@Id
	@GeneratedValue(generator = "mob_gen",strategy = GenerationType.AUTO)
	@SequenceGenerator(name="mob_gen",sequenceName = "mobile_seq")
	private Integer mobileId;
	private String model;
	private String brand;
	private double price;
}
