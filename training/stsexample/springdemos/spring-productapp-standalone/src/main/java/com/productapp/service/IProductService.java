package com.productapp.service;

import java.util.List;

import com.productapp.exception.ProductNotFoundException;
import com.productapp.model.Product;

public interface IProductService {
	
	Product getById(int productid) throws ProductNotFoundException;
	List<Product>getAll();
	List<Product>getByCategory(String category) throws ProductNotFoundException;
}
