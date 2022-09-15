package com.shristi.javabased;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

// the class  with all bean definition
@Configuration
public class AppConfig {
	
	@Bean  // spring reads the method annoted with Bean and creats the object
	public Vehicle getVehicle() {
		Vehicle vehicle=new Vehicle();
		vehicle.setBrand("Audi");
		vehicle.setPrice(9000);
		vehicle.setEngine(getEngine());
		return vehicle;
				
	}
	
	@Bean  
	@Primary
	public Engine getEngine() {
		Engine engine=new Engine();
		engine.setMileage("12km/hr");
		engine.setType("petrol");
		return engine;
				
	}
}
