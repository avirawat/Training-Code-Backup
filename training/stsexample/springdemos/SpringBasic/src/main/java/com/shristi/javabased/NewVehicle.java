package com.shristi.javabased;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

//@Component
public class NewVehicle {
	
	private String brand;
	private double price;
	
	private NewEngine newEngine;
	
	public String getBrand() {
		return brand;
	}
	@Value("Honda")
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public double getPrice() {
		return price;
	}
	@Value("230000")
	public void setPrice(double price) {
		this.price = price;
	}

	public NewEngine getNewEngine() {
		return newEngine;
	}
	@Autowired
	public void setNewEngine(NewEngine newEngine) {
		this.newEngine = newEngine;
	}

	@Override
	public String toString() {
		return "NewVehicle [brand=" + brand + ", price=" + price + ", newEngine=" + newEngine + "]";
	}
	
	
	
	
	
}
