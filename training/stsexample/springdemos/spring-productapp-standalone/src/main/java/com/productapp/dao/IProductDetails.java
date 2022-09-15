package com.productapp.dao;

import java.util.List;

import com.productapp.exception.ProductNotFoundException;
import com.productapp.model.Product;

public interface IProductDetails {
	Product findById(int productid) throws ProductNotFoundException;
	List<Product>findAll();
	List<Product>findByCategory(String category) throws ProductNotFoundException;

}
