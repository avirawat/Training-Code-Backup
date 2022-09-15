package com.shristi.javabased;

import java.util.stream.Stream;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainVehicle {

	public static void main(String[] args) {
	
		ApplicationContext context=new AnnotationConfigApplicationContext("com.shristi.javabased");
		
		String[] beansName=context.getBeanDefinitionNames();
		Stream.of(beansName).forEach(System.out::println);
		
		NewVehicle newVehicle=context.getBean(NewVehicle.class);
		System.out.println(newVehicle);
		


	}

}
