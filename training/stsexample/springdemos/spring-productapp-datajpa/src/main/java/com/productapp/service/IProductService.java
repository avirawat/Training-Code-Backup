package com.productapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.productapp.exception.ProductNotFoundException;
import com.productapp.model.BrandView;
import com.productapp.model.PriceView;
import com.productapp.model.Product;
import com.productapp.model.ProductDetailsDTO;
import com.productapp.model.ProductView;

@Service
public interface IProductService {
	
	Product addProduct(Product product);
	void updateProduct(Product product);
	void deleteProduct(int productId);
	
	Product getById(int productid) throws ProductNotFoundException;
	List<Product>getAll();
	
	List<Product>getByCategory(String category) throws ProductNotFoundException;
	List<Product>getByBrand(String brand) throws ProductNotFoundException;
	List<Product>getByLessPrice(double price) throws ProductNotFoundException;
	//new funcitons
	List<Product>getByCategoryAndBrand(String category,String brand) throws ProductNotFoundException;
	List<Product>getByCategoryIgnore(String category) throws ProductNotFoundException;
	List<Product>getByCategoryAndPrice(String category,double price) throws ProductNotFoundException;
	List<Product>getLikeBrand(String brand) throws ProductNotFoundException;
		
	//projection
	List<ProductDetailsDTO> getByDetailsCategory(String category);
	
	public BrandView getByProductName(String productName);
	
	public PriceView getByName(String productName);
	
	List<ProductView> getProductBtBrand(String brand);
}
