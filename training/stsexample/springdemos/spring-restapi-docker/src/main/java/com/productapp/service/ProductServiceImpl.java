package com.productapp.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.productapp.model.Product;


@Service
public class ProductServiceImpl implements IProductService {

	@Override
	public Product getById(int productid) {
		return showProducts()
				.stream()
				.filter((product)->product.getProductId()==productid).findAny().get();
	
	}

	@Override
	public List<Product> getAll() {
		return showProducts();
	}

	@Override
	public List<Product> getByCategory(String category) {
		return showProducts()
				.stream()
				.filter((product)->product.getCategory().equals(category))
				.collect(Collectors.toList());
	}

	@Override
	public List<Product> getByBrand(String brand) {
		return showProducts()
				.stream()
				.filter((product)->product.getBrand().equals(brand))
				.collect(Collectors.toList());
	}
	
	private List<Product> showProducts() {
		return Arrays.asList(
				new Product("Laptop",1,9000.0,"Gadgets","Dell"),
				new Product("HeadPhone",2,3000.0,"Gadgets","JBL"),
				new Product("Speaker",1,2000.0,"Gadgets","JBL"),
				new Product("pen",1,100.0,"Stationary","Parker"),
				new Product("KeyBoard",1,9000.0,"Gadgets","Lenovo"),
				new Product("Harddisk",1,9000.0,"Gadgets","Lenovo")
				);
				
	}
	
}
