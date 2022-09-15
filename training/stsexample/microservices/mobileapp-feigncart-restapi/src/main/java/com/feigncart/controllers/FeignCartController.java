package com.feigncart.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.feigncart.model.Cart;
import com.feigncart.model.Mobile;
import com.feigncart.service.IFeignCartProxyService;

@RestController
@RequestMapping("/feign-cart-service")
public class FeignCartController {
	
	@Autowired
	IFeignCartProxyService cartService;
	
	List<Mobile> mobileItems=new ArrayList<>();
	Cart cart=new Cart();
	
	@GetMapping("/cart/brand/{brand}")
	public List<Mobile> getByBrand(@PathVariable("brand") String brand) {
		return cartService.getByBrand(brand);
	}
	@GetMapping("/cart/mobileid/{mobileid}")
	public Mobile showOne(@PathVariable("mobileid") int mobileid) {
		return cartService.getById(mobileid);
	}
	//cart-service/cart/add-cart/mobileid/1
	@GetMapping("/cart/add-cart/mobileid/{mobileid}")
	public String addToCart(@PathVariable("mobileid") int mobileid) {
		Mobile mobile=cartService.getById(mobileid);
		mobileItems.add(mobile);
		cart.setCartId(1);
		cart.setMobiles(mobileItems);
		cart.setQuantity(2);
		cart.setTotalPrice(120000);
		return "mobile added";
	}
	
	@GetMapping("/cart/view-cart")
	public Cart viewCart() {
		return cart;
	}
}
