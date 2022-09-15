package com.shristi.autojavabased;

import org.springframework.stereotype.Component;


public class Triangle implements Shape {

	public void area(int length, int breadth) {
		System.out.println("Triangle "+(0.5)*length*breadth);

	}

}
