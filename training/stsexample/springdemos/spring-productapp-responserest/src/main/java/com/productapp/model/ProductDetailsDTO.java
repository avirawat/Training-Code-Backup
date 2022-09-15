package com.productapp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString

//DTO Projection using Class
//should have the instance variables similiar to the entitiy class (whtver required)
//should have only one constructor with all instance variable
public class ProductDetailsDTO {
	
	private String productName;
	private String brand;
}
