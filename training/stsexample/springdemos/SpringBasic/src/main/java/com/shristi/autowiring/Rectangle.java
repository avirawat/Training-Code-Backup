package com.shristi.autowiring;

import org.springframework.stereotype.Component;

@Component
public class Rectangle implements Shape {

	public void area(int length, int breadth) {
		System.out.println("rectangle "+length*breadth);

	}

}
