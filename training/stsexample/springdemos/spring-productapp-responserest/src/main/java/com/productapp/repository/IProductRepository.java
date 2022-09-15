package com.productapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.productapp.model.PriceView;
import com.productapp.model.Product;

@Repository
public interface IProductRepository extends JpaRepository<Product, Integer> {

	
	List<Product> findByCategory(String category);

	List<Product> readByBrand(String brand);
	
	List<Product> findByPriceLessThan(double price);
	
	List<Product> findByCategoryAndBrand(String category,String brand);
	

	
}
