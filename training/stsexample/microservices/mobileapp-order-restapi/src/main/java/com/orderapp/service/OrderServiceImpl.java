package com.orderapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.orderapp.model.Cart;
import com.orderapp.model.Order;

@Service
public class OrderServiceImpl implements OrderService{

	@Autowired
	RestTemplate restTemplate;
	
	private static final String BASEURL="http://CART-SERVICE/cart-service/";
	
	@Override
	public Order viewOrderDetails() {
		String url=BASEURL+"/cart/view-cart";
		HttpHeaders headers=new HttpHeaders();
		headers.set("desc" , " cart details");
		
		HttpEntity<Object> entity=new HttpEntity<>(headers);
		ResponseEntity<Cart> response=restTemplate.exchange(url, HttpMethod.GET,entity,Cart.class);
		Cart cart=response.getBody();
		Order order=new Order();
		order.setOrderId(1);
		order.setCity("Hyd");
		order.setOrderTotal(cart.getTotalPrice());
		order.setPaymentMode("cash");
		return order;
	}

}
