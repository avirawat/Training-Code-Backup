package com.productapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.productapp.exception.ProductNotFoundException;
import com.productapp.model.Product;
import com.productapp.service.IProductService;

@SpringBootApplication
public class SpringProductappStandaloneApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringProductappStandaloneApplication.class, args);
	}
	@Autowired
	IProductService productService;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		productService.getAll().forEach(System.out::println);
		
		System.out.println(productService.getById(1));
		
		productService.getByCategory("gadgets").forEach(product-> {
		System.out.println(product.getProductName()+" "+product.getPrice());
		});
		 //throw EXception
		try {
		Product prod=productService.getById(9);
		System.out.println(prod);
		}catch(ProductNotFoundException e) {
			System.out.println(e.getMessage());
		}
		try {
		productService.getByCategory("abc").forEach(product-> {
			System.out.println(product.getProductName()+" "+product.getPrice());
			});
		}catch(ProductNotFoundException e) {
			System.out.println(e.getMessage());
		}
	
	}

}
