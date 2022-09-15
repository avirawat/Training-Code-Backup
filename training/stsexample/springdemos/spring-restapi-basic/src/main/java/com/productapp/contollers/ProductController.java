package com.productapp.contollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.productapp.model.Product;
import com.productapp.service.IProductService;

@RestController
@RequestMapping("/product-api")
public class ProductController {
	
	@Autowired
	IProductService productService;
	
	//http://localhost:8080/product-api/products
	@GetMapping("/products")
	public List<Product>getAllProducts() {
		return productService.getAll();
	}
	//http://localhost:8080/product-api/products/?productid=1
	@GetMapping("/products/{productid}")
	public Product getById(int productid) {
		return productService.getById(productid);
	}
	//http://localhost:8080/product-api/products/category/Gadgets
	@GetMapping("/products/category/{category}")
	public List<Product>getByCategory(@PathVariable("category")String category){
		return productService.getByCategory(category);
	}
	//http://localhost:8080/product-api/products/brand/Lenovo
	@GetMapping("/products/brand/{mbrand}")
	public List<Product>getByBrand(@PathVariable("mbrand")String brand){
		return productService.getByBrand(brand);
	}
}
