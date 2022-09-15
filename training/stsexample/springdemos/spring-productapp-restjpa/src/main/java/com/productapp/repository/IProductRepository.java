package com.productapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.productapp.model.PriceView;
import com.productapp.model.Product;

@Repository
public interface IProductRepository extends JpaRepository<Product, Integer> {

	// derived queries
	// findBy-----/readBy----/getBy

	List<Product> findByCategory(String category);

	List<Product> readByBrand(String brand);
	
	List<Product> findByPriceLessThan(double price);
	
	List<Product> findByCategoryAndBrand(String category,String brand);
	
	List<Product> findByCategoryIgnoreCase(String category);
	
	List<Product> findByCategoryAndPriceLessThan(String category,double price);
	
	// custom query use @Query and JPQL
	
	@Query("from Product p where p.category= ?1")
	List<Product> findByCat(String category);
	
	@Query("from Product p where p.category= ?1 and p.brand= ?2")
	List<Product> findByCatandBrand(String category,String Brand);
	
	@Query("from Product p where p.brand like %?1%")
	List<Product> findByBrand(String brand);
	
	@Query(value="select * from newproduct where category=?1 and price<=?2", nativeQuery=true)
	List<Product>findByCategoryAndPrice(String category,double price);
	
	// projection
	public PriceView findByProductName(String productName);
	
	
}
