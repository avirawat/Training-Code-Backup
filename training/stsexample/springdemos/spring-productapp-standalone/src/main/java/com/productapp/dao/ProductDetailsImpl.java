package com.productapp.dao;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.productapp.exception.ProductNotFoundException;
import com.productapp.model.Product;

@Component
public class ProductDetailsImpl implements IProductDetails {

	@Override
	public Product findById(int productid) throws ProductNotFoundException {
		
		return showProducts()
				.stream()
				.filter((product)->product.getProductId()==productid)
				.findAny()
				.orElseThrow(()-> new ProductNotFoundException("product not found"));
	}

	@Override
	public List<Product> findAll() {

		return showProducts()
				.stream().
				sorted(Comparator.comparing(Product::getProductName))
				.collect(Collectors.toList());
	}

	@Override
	public List<Product> findByCategory(String category) throws ProductNotFoundException {
		return showProducts()
				.stream()
				.filter((product)->product.getCategory().equals(category))
				.collect(Collectors.toList());

	}
	
	private static List<Product> showProducts() {
		return Arrays.asList(
				new Product("Laptop",1,9000,"gadgets"),
				new Product("mobile",2,24000,"gadgets"),
				new Product("notebook",3,90,"stationary"),
				new Product("pencil",4,100,"stationary"),
				new Product("Laptop",5,3000,"gadgets"));
	}
}
