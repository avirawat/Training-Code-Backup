package com.productapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.productapp.dao.IProductDetails;
import com.productapp.exception.ProductNotFoundException;
import com.productapp.model.Product;

@Service
public class ProductServiceImpl implements IProductService {

	@Autowired
	IProductDetails productDetails;

	@Override
	public Product getById(int productid) throws ProductNotFoundException {

		return productDetails.findById(productid);
	}

	@Override
	public List<Product> getAll() {
		return productDetails.findAll();
	}

	@Override
	public List<Product> getByCategory(String category) throws ProductNotFoundException {
		List<Product> productByCategory = productDetails.findByCategory(category);
		if (productByCategory.isEmpty()) {
			throw new ProductNotFoundException("Category not found");
		}
		return productByCategory;
	}

}
