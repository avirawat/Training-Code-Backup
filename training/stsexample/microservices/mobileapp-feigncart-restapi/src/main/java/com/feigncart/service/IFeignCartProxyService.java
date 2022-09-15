package com.feigncart.service;


import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.feigncart.model.Mobile;

// this is a declative client calling the other  microservices MOBILE-SERVICE
// Feign will provide the implementation of this class int the runtime
// give the name of service to which you want 

@FeignClient(name="MOB-SERVICE")
public interface IFeignCartProxyService {
	
	@GetMapping("/mobile-service/mobiles/brand/{brand}")
	public List<Mobile> getByBrand(@PathVariable("brand")String brand);
	
	@GetMapping("/mobile-service/mobiles/{mobileid}")
	public Mobile getById(@PathVariable("mobileid")int id);
	

}
