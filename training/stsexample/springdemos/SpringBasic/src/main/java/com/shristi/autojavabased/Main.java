package com.shristi.autojavabased;

import java.util.stream.Stream;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	public static void main(String[] args) {
	
		ApplicationContext context=new AnnotationConfigApplicationContext("com.shristi.autojavabased");

		ShapeFactory factory=context.getBean(ShapeFactory.class);
		factory.printArea("r",10, 20);
		factory.printArea("t",10, 20);
		factory.printArea("s",10, 20);
		
		String[] beansname=context.getBeanDefinitionNames();
		Stream.of(beansname).forEach(System.out::println);
	}

}
