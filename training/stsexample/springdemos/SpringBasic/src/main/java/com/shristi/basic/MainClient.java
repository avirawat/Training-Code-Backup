package com.shristi.basic;

import java.util.stream.Stream;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainClient {

	public static void main(String[] args) {
	
		ApplicationContext context=new AnnotationConfigApplicationContext("com.shristi.basic");
		
		Employee employee=(Employee)context.getBean("employee");
//		Employee employee1=context.getBean("employee",Employee.class);
//		Employee employee2=context.getBean(Employee.class);
		
		System.out.println(employee);
		
		Address address=context.getBean("address",Address.class);
		System.out.println(address);
		
		String[] beansname=context.getBeanDefinitionNames();
		Stream.of(beansname).forEach(System.out::println);
	}

}
