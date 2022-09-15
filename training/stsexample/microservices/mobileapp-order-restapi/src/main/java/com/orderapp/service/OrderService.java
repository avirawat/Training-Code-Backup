package com.orderapp.service;

import org.springframework.stereotype.Service;

import com.orderapp.model.Order;

@Service
public interface OrderService {

	public Order viewOrderDetails();
	
}
