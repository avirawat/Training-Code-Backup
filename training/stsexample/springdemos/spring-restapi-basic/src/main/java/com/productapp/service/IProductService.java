package com.productapp.service;

import java.util.List;

import com.productapp.model.Product;

public interface IProductService {
	
	Product getById(int productid);
	List<Product>getAll();
	List<Product>getByCategory(String category) ;
	List<Product>getByBrand(String brand) ;
}
