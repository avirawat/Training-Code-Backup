package com.productapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.productapp.exception.ProductNotFoundException;
import com.productapp.model.BrandView;
import com.productapp.model.PriceView;
import com.productapp.model.Product;
import com.productapp.model.ProductDetailsDTO;
import com.productapp.model.ProductView;
import com.productapp.repository.IProductDetailsRepository;
import com.productapp.repository.IProductRepository;



@Service
public class ProductServiceImpl implements IProductService {

	@Autowired
	IProductRepository productRepository;
	
	@Autowired
	IProductDetailsRepository productDetailsRepository;
	
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
		Optional<Product>prodOpt=productRepository.findById(productid);
		if(prodOpt.isEmpty()) {
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
		return productRepository.findByCat(category);
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
	//return productRepository.findByCategoryAndBrand(category, brand);
		return productRepository.findByCatandBrand(category, brand);
	}

	@Override
	public List<Product> getByCategoryIgnore(String category) throws ProductNotFoundException {
		return productRepository.findByCategoryIgnoreCase(category);
	}

	@Override
	public List<Product> getByCategoryAndPrice(String category, double price) throws ProductNotFoundException {
	//return productRepository.findByCategoryAndPriceLessThan(category, price);
		return productRepository.findByCategoryAndPrice(category, price);
		
	}

	@Override
	public List<Product> getLikeBrand(String brand) throws ProductNotFoundException {
		return productRepository.findByBrand(brand);
	}

	@Override
	public List<ProductDetailsDTO> getByDetailsCategory(String category) {
		return productDetailsRepository.findByCategory(category);
	}

	@Override
	public BrandView getByProductName(String productName) {
	 return productDetailsRepository.findByProductName(productName);
	}

	@Override
	public PriceView getByName(String productName) {
		return productRepository.findByProductName(productName);
	}

	@Override
	public List<ProductView> getProductBtBrand(String brand) {
		return productDetailsRepository.findByBrand(brand);
	}

	

}
