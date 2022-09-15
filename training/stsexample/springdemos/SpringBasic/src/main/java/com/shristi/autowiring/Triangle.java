package com.shristi.autowiring;

import org.springframework.stereotype.Component;

@Component("tshape")
public class Triangle implements Shape {

	public void area(int length, int breadth) {
		System.out.println("Triangle "+(0.5)*length*breadth);

	}

}
