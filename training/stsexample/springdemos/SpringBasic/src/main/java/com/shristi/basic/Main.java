package com.shristi.basic;

import java.util.stream.Stream;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	public static void main(String[] args) {
		ApplicationContext context=new AnnotationConfigApplicationContext("com.shristi.basic");
		
		Mobile mobile=(Mobile)context.getBean("mobile",Mobile.class);
		System.out.println(mobile);
		System.out.println(mobile.getFeatures().getOs());
		System.out.println(mobile.getFeatures().getProcessor());
		
		
		Features features=context.getBean("features",Features.class);
		System.out.println(features);
		
		String[] beansname=context.getBeanDefinitionNames();
		Stream.of(beansname).forEach(System.out::println);
	}

}
