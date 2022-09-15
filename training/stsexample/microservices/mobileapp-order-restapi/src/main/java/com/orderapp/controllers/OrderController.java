package com.orderapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.orderapp.model.Order;
import com.orderapp.service.OrderService;

@RestController
@RequestMapping("/order-service")
public class OrderController {
	
	@Autowired
	OrderService orderService;
	
	@GetMapping("/orders/view-order")
	public Order viewOrderDetails(@RequestHeader("desc") String header) {
		System.out.println(header);
		return orderService.viewOrderDetails();
	}
	
	@GetMapping("/orders/pay")
	public String proceedToPay(@RequestHeader("payment") String header) {
		System.out.println(header);
		return "payment sucessfull";
	}
}
