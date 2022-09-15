package com.productapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.productapp.exception.ProductNotFoundException;
import com.productapp.model.Product;
import com.productapp.repository.IProductRepository;

@Service
public class ProductServiceImpl implements IProductService {

	@Autowired
	IProductRepository productRepository;

	public void setProductRepository(IProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	@Override
	public Product addProduct(Product product) {
		return productRepository.save(product);

	}

	@Override
	public void updateProduct(Product product) {
		productRepository.save(product);
	}

	@Override
	public void deleteProduct(int productId) {
		productRepository.deleteById(productId);

	}

	@Override
	public Product getById(int productid) throws ProductNotFoundException {
		Optional<Product> prodOpt = productRepository.findById(productid);
		if (prodOpt.isEmpty()) {
			throw new ProductNotFoundException("invalid id");
		}
		return prodOpt.get();

//		return productRepository
//				.findAllById(productid)
//				.orElseThrow(()->new ProductNotFoundException("invalid id"));
	}

	@Override
	public List<Product> getAll() {
		return productRepository.findAll();
	}

	@Override
	public List<Product> getByCategory(String category) throws ProductNotFoundException {
		List<Product> productList=productRepository.findByCategory(category);
		if(productList.isEmpty()) {
			throw new ProductNotFoundException("Category not found");
		}
		return productList;
	}

	@Override
	public List<Product> getByBrand(String brand) throws ProductNotFoundException {
		return productRepository.readByBrand(brand);
	}

	@Override
	public List<Product> getByLessPrice(double price) throws ProductNotFoundException {
		return productRepository.findByPriceLessThan(price);
	}

	@Override
	public List<Product> getByCategoryAndBrand(String category, String brand) throws ProductNotFoundException {

		return productRepository.findByCategoryAndBrand(category, brand);
	}

}
