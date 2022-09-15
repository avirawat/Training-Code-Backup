package com.shristi.javabased;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//@Component
public class Vehicle {
	
	private String brand;
	private double price;
	
	private Engine engine;
	
	public String getBrand() {
		return brand;
	}
	//@Value("Honda")
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public double getPrice() {
		return price;
	}
	//@Value("20000")
	public void setPrice(double price) {
		this.price = price;
	}
	
	
	public Engine getEngine() {
		return engine;
	}
	public void setEngine(Engine engine) {
		this.engine = engine;
	}
	
	@Override
	public String toString() {
		return "Vehicle [brand=" + brand + ", price=" + price + ", engine=" + engine + "]";
	}
	
	
	
	
}
