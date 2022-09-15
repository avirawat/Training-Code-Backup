package com.shristi.autojavabased;

import org.springframework.stereotype.Component;


public class Rectangle implements Shape {

	public void area(int length, int breadth) {
		System.out.println("rectangle "+length*breadth);

	}

}
