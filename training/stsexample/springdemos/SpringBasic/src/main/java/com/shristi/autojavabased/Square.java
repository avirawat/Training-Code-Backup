package com.shristi.autojavabased;

import org.springframework.stereotype.Component;

@Component
public class Square implements Shape {

	public void area(int length, int breadth) {
		System.out.println("Square "+length*breadth);

	}

}
