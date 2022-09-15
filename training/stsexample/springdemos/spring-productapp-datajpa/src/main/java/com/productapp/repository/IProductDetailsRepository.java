package com.productapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.productapp.model.BrandView;
import com.productapp.model.Product;
import com.productapp.model.ProductDetailsDTO;
import com.productapp.model.ProductView;

@Repository
public interface IProductDetailsRepository extends JpaRepository<Product,Integer> {

	//DTO projection
	List<ProductDetailsDTO> findByCategory(String category);
	
	public BrandView findByProductName(String productName);
	
	List<ProductView> findByBrand(String brand);
}
