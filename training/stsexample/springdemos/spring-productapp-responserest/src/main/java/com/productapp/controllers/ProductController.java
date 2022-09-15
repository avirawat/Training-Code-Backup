package com.productapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.productapp.exception.ProductNotFoundException;
import com.productapp.model.Product;
import com.productapp.service.IProductService;

@RestController
@RequestMapping("/product-api")
public class ProductController {

	@Autowired
	IProductService productService;

	@PostMapping("/products")
	ResponseEntity<Product> addProduct(@RequestBody Product product) {
		Product nproProduct = productService.addProduct(product);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "Product Addedd");
		return ResponseEntity.status(HttpStatus.CREATED).headers(headers).body(nproProduct);
	}

	@PutMapping("/products")
	ResponseEntity<Void> updateProduct(@RequestBody Product product) {
		productService.updateProduct(product);
		return ResponseEntity.status(HttpStatus.ACCEPTED).build();
	}

	@DeleteMapping("/products/{productId}")
	ResponseEntity<String> deleteProduct(@PathVariable("productId") int productId) {
		productService.deleteProduct(productId);
		return ResponseEntity.status(HttpStatus.OK).body("deleted successfully");
	}

	@GetMapping("/products/{productId}")
	ResponseEntity<Product> getById(@PathVariable("productId") int productid) throws ProductNotFoundException {
		Product product = productService.getById(productid);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "Get one product By id");
		headers.add("info", "Returning one product");
		ResponseEntity<Product> productResponse = new ResponseEntity<Product>(product, headers, HttpStatus.OK);
		return productResponse;
	}

	@GetMapping("/products")
	ResponseEntity<List<Product>> getAll() {
		List<Product> productList = productService.getAll();
		return ResponseEntity.ok(productList);
	}

	@GetMapping("/products/categoryname/{category}")
	ResponseEntity<List<Product>> getByCategory(@PathVariable("category") String category)
			throws ProductNotFoundException {
		List<Product> productListCategory = productService.getByCategory(category);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc","product List By category");
		return  ResponseEntity.status(HttpStatus.OK).headers(headers).body(productListCategory);
	}

	@GetMapping("/products/brand/{brand}")
	ResponseEntity<List<Product>>  getByBrand(@PathVariable("brand") String brand) throws ProductNotFoundException {
		List<Product> productListBrand = productService.getByBrand(brand);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc","product List By brand");
		return  ResponseEntity.status(HttpStatus.OK).headers(headers).body(productListBrand);
	}

	@GetMapping("/products/price")
	ResponseEntity<List<Product>>  getByLessPrice(@RequestParam("price") double price) throws ProductNotFoundException {
		List<Product> productListPrice = productService.getByLessPrice(price);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc","product List By Pric");
		return  ResponseEntity.status(HttpStatus.OK).headers(headers).body(productListPrice);
	}

	@GetMapping("/products/category/{category}/brand/{brand}")
	ResponseEntity<List<Product>>  getByCategoryAndBrand(@PathVariable("category") String category, @PathVariable("brand") String brand)
			throws ProductNotFoundException {
		List<Product> productListBrandAndCategory = productService.getByCategoryAndBrand(category, brand);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc","product List By brand And Vatgeory");
		return  ResponseEntity.status(HttpStatus.OK).headers(headers).body(productListBrandAndCategory);
	}

}
