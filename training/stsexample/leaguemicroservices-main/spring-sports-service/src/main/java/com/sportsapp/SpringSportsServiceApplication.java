package com.sportsapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SpringSportsServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSportsServiceApplication.class, args);
	}

}
