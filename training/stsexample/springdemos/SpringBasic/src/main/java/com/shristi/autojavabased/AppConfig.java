package com.shristi.autojavabased;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class AppConfig {

	@Bean
	public Shape srectangle() {
		return new Rectangle();
	}
	
	@Bean
	public Shape striangle() {
		return new Triangle();
	}
	
	@Bean
	@Primary
	public Shape ssquare() {
		return new Square();
	}
	
	@Bean
	public ShapeFactory factory() {
		return new ShapeFactory();
	}
}
