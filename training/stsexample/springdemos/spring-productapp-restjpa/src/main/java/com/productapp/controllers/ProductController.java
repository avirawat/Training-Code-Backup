package com.productapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.productapp.exception.ProductNotFoundException;
import com.productapp.model.BrandView;
import com.productapp.model.PriceView;
import com.productapp.model.Product;
import com.productapp.model.ProductDetailsDTO;
import com.productapp.model.ProductView;
import com.productapp.service.IProductService;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("product-api")
public class ProductController {
	
	@Autowired
	IProductService productService;
	
	
	public void setProductService(IProductService productService) {
		this.productService = productService;
	}
	@PostMapping("/products")
	Product addProduct(@RequestBody Product product){
		return productService.addProduct(product);
	}
	@PutMapping("/products")
	void updateProduct(@RequestBody Product product){
		productService.updateProduct(product);
	}
	@DeleteMapping("/products/{productId}")
	void deleteProduct(int productId){
		productService.deleteProduct(productId);
	}
	@GetMapping("/products/{productId}")
	Product getById(@PathVariable("productId")int productid) throws ProductNotFoundException{
		return productService.getById(productid);
	}
	@GetMapping("/products")
	List<Product>getAll(){
		return productService.getAll();
	}
	@GetMapping("/products/category/{category}")
	List<Product>getByCategory(@PathVariable("category")String category) throws ProductNotFoundException{
		return productService.getByCategory(category);
	}
	@GetMapping("/products/brand/{brand}")
	List<Product>getByBrand(@PathVariable("brand")String brand) throws ProductNotFoundException{
		return productService.getByBrand(brand);
	}
	@GetMapping("/products/price/{price}")
	List<Product>getByLessPrice(@PathVariable("price")double price) throws ProductNotFoundException{
		return productService.getByLessPrice(price);
	}
	//new funcitons
	@GetMapping("/products/category/{category}/brand/{brand}")
	List<Product>getByCategoryAndBrand(@PathVariable("category")String category,@PathVariable("brand")String brand) throws ProductNotFoundException{
		return productService.getByCategoryAndBrand(category, brand);
	}
	
	@GetMapping("/products/category/{category}/price/{price}")
	List<Product>getByCategoryAndPrice(@PathVariable("category")String category,@PathVariable("price")double price) throws ProductNotFoundException{
		return productService.getByCategoryAndPrice(category, price);
	}
	
	@GetMapping("/products/categoryname/{category}")
	List<ProductDetailsDTO> getByDetailsCategory(@PathVariable("category")String category){
		return productService.getByDetailsCategory(category);
	}
	@GetMapping("/products/productname/{productName}")
	public BrandView getByProductName(@PathVariable("productName")String productName){
		return productService.getByProductName(productName);
	}
	@GetMapping("/products/name/{productName}")
	public PriceView getByName(@PathVariable("productName")String productName){
		return productService.getByName(productName);
	}
	@GetMapping("/products/brandname/{brand}")
	List<ProductView> getProductBtBrand(@PathVariable("brand")String brand){
		return productService.getProductBtBrand(brand);
	}
}
