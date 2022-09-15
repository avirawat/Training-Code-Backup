package com.shristi.javabased;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfig {
	
	@Bean
	public NewVehicle getnewVehicle() {
		return new NewVehicle();
	}
	
	@Bean
	public NewEngine getNewEngine() {
		return new NewEngine();
	}
}
