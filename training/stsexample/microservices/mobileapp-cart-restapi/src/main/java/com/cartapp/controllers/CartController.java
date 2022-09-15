package com.cartapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cartapp.model.Cart;
import com.cartapp.model.Mobile;
import com.cartapp.service.CartService;

@RestController
@RequestMapping("/cart-service")
public class CartController {
	
	@Autowired
	CartService cartService;
	
	@GetMapping("/cart/brand/{brand}")
	public List<Mobile> getByBrand(@PathVariable("brand") String brand) {
		return cartService.getByBrand(brand);
	}
	@GetMapping("/cart/mobileid/{mobileid}")
	public Mobile showOne(@PathVariable("mobileid") int mobileid) {
		return cartService.getById(mobileid);
	}
	//http://localhost:8082/cart-service/cart/add-cart/mobileid/1
	@GetMapping("/cart/add-cart/mobileid/{mobileid}")
	public String addToCart(@PathVariable("mobileid") int mobileid) {
		cartService.addToCart(mobileid);
		return "mobile added";
	}
	
	@GetMapping("/cart/view-cart")
	public Cart viewCart(@RequestHeader("desc") String header) {
		return cartService.showCart();
	}
}
