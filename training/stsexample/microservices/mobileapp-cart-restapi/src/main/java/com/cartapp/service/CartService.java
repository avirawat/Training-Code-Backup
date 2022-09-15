package com.cartapp.service;


import java.util.List;

import org.springframework.stereotype.Service;

import com.cartapp.model.Cart;
import com.cartapp.model.Mobile;

@Service
public interface CartService {
	
	public List<Mobile> getByBrand(String brand);

	public Mobile getById(int id);
	
	public void addToCart(int mobileid);
	
	public Cart showCart();
}
