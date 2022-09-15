package com.productapp.model;

import org.springframework.beans.factory.annotation.Value;

public interface ProductView {
	
	@Value("#{target.productName+''+target.price}")
	String getDetails();
}
