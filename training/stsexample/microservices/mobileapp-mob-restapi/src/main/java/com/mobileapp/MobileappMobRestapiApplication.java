package com.mobileapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MobileappMobRestapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(MobileappMobRestapiApplication.class, args);
	}

}
