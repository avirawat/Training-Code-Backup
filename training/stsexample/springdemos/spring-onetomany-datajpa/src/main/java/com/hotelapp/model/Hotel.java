package com.hotelapp.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Hotel {
	@Id
	@GeneratedValue(generator = "hotel_gen", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "hotel_gen", sequenceName = "hotel_seq", initialValue = 100, allocationSize = 1)
	private Integer hotelId;
	@Column(length = 20)
	private String name;
	@Column(length = 20)
	private String type;
	@Column(length = 20)
	private String city;
	private double rating;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER,mappedBy ="hotel")
	private Set<Menu> menuList;

	public Hotel(String name, String type, String city, double rating, Set<Menu> menuList) {
		super();
		this.name = name;
		this.type = type;
		this.city = city;
		this.rating = rating;
		this.menuList = menuList;
	}

}
