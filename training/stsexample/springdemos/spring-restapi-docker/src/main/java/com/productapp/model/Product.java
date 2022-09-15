package com.productapp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Product {
	
	private String productName;
	private Integer productId;
	private Double price;
	private String category;
	private String brand;
	
	public Product(String productName, Integer productId, Double price, String category, String brand) {
		super();
		this.productName = productName;
		this.productId = productId;
		this.price = price;
		this.category = category;
		this.brand = brand;
	}
	
	
}

