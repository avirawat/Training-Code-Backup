package com.shristi.autowiring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	public static void main(String[] args) {
	
		ApplicationContext context=new AnnotationConfigApplicationContext("com.shristi.autowiring");
		//Shape shape=context.getBean("rectangle",Rectangle.class);
//		shape.area(10,20);
//		shape=(Shape)context.getBean("triangle");
//		shape.area(10, 30);
//		shape=context.getBean(Square.class);
//		shape.area(10, 20);
		
		// for sauwiting
		ShapeFactory factory=context.getBean("shapeFactory",ShapeFactory.class);
		factory.printArea("r",10, 20);
		factory.printArea("t",10, 20);
		factory.printArea("s",10, 20);
	}

}
