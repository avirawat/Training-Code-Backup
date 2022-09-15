package com.productapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.productapp.exception.IdNotFoundException;
import com.productapp.exception.ProductNotFoundException;
import com.productapp.model.Product;



@Service
public class ProductServiceImpl implements IProductService {
    // to call the rest
	@Autowired
	RestTemplate restTemplate;
	public static final String BASEURL="http://localhost:8080/product-api";
	
	@Override
	public void addProduct(Product product) {
		
		
	}

	@Override
	public void updateProduct(int productId, double price) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteProduct(int productId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Product getById(int productid) throws IdNotFoundException {
		String url=BASEURL+"/products/1";
		ResponseEntity<Product> response=restTemplate.getForEntity(url,Product.class);
		System.out.println(response.getStatusCodeValue()+"......");
		return response.getBody();
	}

	@Override
	public List<Product> getAll() {
		String url=BASEURL+"/products";
		ResponseEntity<List>response=restTemplate.getForEntity(url,List.class);
		return response.getBody();
	}

	@Override
	public List<Product> getByCategory(String category) throws ProductNotFoundException {
		String url=BASEURL+"/products/categoryname/"+category;
		ResponseEntity<List>response=restTemplate.getForEntity(url,List.class);
		HttpHeaders headers=response.getHeaders();
		List<String>header=headers.get("desc");
		System.out.println(response.getStatusCodeValue()+"......");
		return response.getBody();
	}

	@Override
	public List<Product> getByLessPrice(double price) throws ProductNotFoundException {
		String url=BASEURL+"/products/price/"+price;
		ResponseEntity<List>response=restTemplate.getForEntity(url,List.class);
		HttpHeaders headers=response.getHeaders();
		List<String>header=headers.get("desc");
		System.out.println(response.getStatusCodeValue()+"......");
		return response.getBody();
	}

	
	

}
