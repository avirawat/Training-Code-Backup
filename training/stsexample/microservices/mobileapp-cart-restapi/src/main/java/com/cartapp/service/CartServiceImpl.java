package com.cartapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cartapp.model.Cart;
import com.cartapp.model.Mobile;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	RestTemplate restTemplate;
	
	private static final String BASEURL="http://MOB-SERVICE/mobile-service/";
	
	List<Mobile> mobileItems=new ArrayList<>();
	Cart cart=new Cart();
	
	@Override
	public List<Mobile> getByBrand(String brand) {
		String url=BASEURL+"mobiles/brand/"+brand;
		ResponseEntity<List>response=restTemplate.getForEntity(url,List.class);
		return response.getBody();
	}

	@Override
	
	public Mobile getById(int id) {
		String url=BASEURL+"/mobiles/"+id;
		ResponseEntity<Mobile> response=restTemplate.getForEntity(url,Mobile.class);
		return response.getBody();
	}

	@Override
	public void addToCart(int mobileid) {
		String url=BASEURL+"/mobiles/"+mobileid;
		Mobile mobile=restTemplate.getForObject(url,Mobile.class);
		mobileItems.add(mobile);
		cart.setCartId(1);
		cart.setMobiles(mobileItems);
		cart.setQuantity(2);
		cart.setTotalPrice(120000);
		
	}

	@Override
	public Cart showCart() {
		return cart;
	}


}
