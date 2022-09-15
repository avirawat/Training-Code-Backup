package com.resilencecart.service;


import java.util.List;

import org.springframework.stereotype.Service;

import com.resilencecart.model.Cart;
import com.resilencecart.model.Mobile;

@Service
public interface CartService {
	
	public List<Mobile> getByBrand(String brand);

	public Mobile getById(int id);
	
	public String addToCart(int mobileid);
	
	public Cart showCart();
}
