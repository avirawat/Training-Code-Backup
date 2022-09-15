package com.hotelapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
public class Menu {
	@Id
	@GeneratedValue(generator = "menu_gen", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "menu_gen", sequenceName = "menu_seq", initialValue = 100, allocationSize = 1)
	private Integer menuId;

	@Column(name = "menuname", length = 20)
	private String menuName;

	@Column(name = "menutype", length = 20)
	private String menuType; // starter or maincources or dessert or breakfast bevrage

	@Column(length = 20)
	private String cuisine;

	private double price;
	
	@ManyToOne
	@JoinColumn(name = "hotel_id")
	private Hotel hotel; 
	
	public Menu(String menuname, String menutype, String cuisine, double price) {
		super();
		this.menuName = menuname;
		this.menuType = menutype;
		this.cuisine = cuisine;
		this.price = price;
	}

	@Override
	public String toString() {
		return "Menu [menuName=" + menuName + ", menuType=" + menuType + ", cuisine=" + cuisine + ", price=" + price
				+ "]";
	}
	
	
}
