package com.productapp.service;

import java.util.List;

import com.productapp.exception.IdNotFoundException;
import com.productapp.exception.ProductNotFoundException;
import com.productapp.model.Product;

public interface IProductService {
	
	void addProduct(Product product);
	void updateProduct(int productId,double price);
	void deleteProduct(int productId);
	
	Product getById(int productid) throws IdNotFoundException;
	List<Product>getAll();
	List<Product>getByCategory(String category) throws ProductNotFoundException;
	List<Product>getByLessPrice(double price) throws ProductNotFoundException;
}
