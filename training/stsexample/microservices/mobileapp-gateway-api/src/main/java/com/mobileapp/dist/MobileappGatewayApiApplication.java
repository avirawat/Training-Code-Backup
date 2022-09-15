package com.mobileapp.dist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
public class MobileappGatewayApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(MobileappGatewayApiApplication.class, args);
	}
	// this mehtod is to build routes
	//using the route builder  builds to routes
	//@Bean
	public RouteLocator customRoutes(RouteLocatorBuilder builder) {
		return builder.routes()
				//create individual routes with path ,uri in proper sequesnce
				// lb is load balkancer pass lonbalanced applictaion name in uri
				.route("mobileAPI",r->
					r.path("/mobile-service/**")
						.uri("lb://MOB-Service"))
				
						//2nd route
						.route("cartAPI",r->
							r.path("/cart-service/**")
								.filters(f->f.addRequestHeader("desc","item added to cart")
										.addResponseHeader("result","showing Cart Data"))
								 .uri("lb://CART-SERVICE"))
						//3rd route for order Microservice
						.route("orderAPI",r->
							r.path("/order-service/**")
							.filters(f->f.addRequestHeader("desc","show order details")
									//.addRequestHeader("payment","UPI Payment")
									.addResponseHeader("result","sending Cart Data"))
							 .uri("lb://ORDER-SERVICE"))
							 .build();
						
						
	}
}
