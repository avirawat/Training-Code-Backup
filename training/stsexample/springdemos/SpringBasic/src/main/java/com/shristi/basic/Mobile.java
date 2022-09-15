package com.shristi.basic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Mobile {
	private String model;
	private String brand;
	private double price;
	
	@Autowired(required = false)
	private Features features;
	
	
//	@Autowired
//	public Mobile(Features features) {
//		super();
//		this.features = features;
//	}
	public String getModel() {
		return model;
	}
	@Value("gaalaxy")
	public void setModel(String model) {
		this.model = model;
	}
	public String getBrand() {
		return brand;
	}
	@Value("Samsung")
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public double getPrice() {
		return price;
	}
	@Value("2300.0")
	public void setPrice(double price) {
		this.price = price;
	}
	public Features getFeatures() {
		return features;
	}
	public void setFeatures(Features features) {
		this.features = features;
	}
	@Override
	public String toString() {
		return "Mobile [model=" + model + ", brand=" + brand + ", price=" + price + ", features=" + features + "]";
	}
	
	
}
