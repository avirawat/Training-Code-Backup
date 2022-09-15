package com.resilencecart.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.resilencecart.model.Cart;
import com.resilencecart.model.Mobile;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	RestTemplate restTemplate;
	
	private static final String BASEURL="http://MOB-SERVICE/mobile-service/";
	
	List<Mobile> mobileItems=new ArrayList<>();
	Cart cart=new Cart();
	
	@Override
	@CircuitBreaker(name="CART_SERVICE",fallbackMethod = "fallBackGetByBrand")
	public List<Mobile> getByBrand(String brand) {
		String url=BASEURL+"mobiles/brand/"+brand;
		List<Mobile> mobileList=restTemplate.getForObject(url,List.class);
		return mobileList;
	}
	//this is fall back methods automatically called by resilenece
	public List<Mobile> fallBackGetByBrand(String brand,RuntimeException e) {

		return new ArrayList<>();
	}


	@Override
	@CircuitBreaker(name="CART_SERVICE",fallbackMethod = "fallBackGetById")
	public Mobile getById(int id) {
		String url=BASEURL+"/mobiles/"+id;
		ResponseEntity<Mobile> response=restTemplate.getForEntity(url,Mobile.class);
		return response.getBody();
	}
	//automatic call bny resilenece
	public Mobile fallBackGetById(int id,RuntimeException e) {
		return new Mobile(0,"no mobile available","no mobile available",0);
	}

	@Override
	@CircuitBreaker(name="CART_SERVICE",fallbackMethod = "fallBackAddToCart")
	public String addToCart(int mobileid) {
		String url=BASEURL+"/mobiles/"+mobileid;
		Mobile mobile=restTemplate.getForObject(url,Mobile.class);
		mobileItems.add(mobile);
		cart.setCartId(1);
		cart.setMobiles(mobileItems);
		cart.setQuantity(2);
		cart.setTotalPrice(120000);
		return "mobile added to cart";
		
	}
	public String fallBackAddToCart(int mobileid,RuntimeException e) {
		cart=null;
		return "items not added in cart";
	}

	@Override
	public Cart showCart() {
		return cart;
	}


}
