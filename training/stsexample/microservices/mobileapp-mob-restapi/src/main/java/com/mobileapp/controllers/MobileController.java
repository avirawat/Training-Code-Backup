package com.mobileapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mobileapp.Service.MobileService;
import com.mobileapp.exception.MobileNotFoundException;
import com.mobileapp.model.Mobile;

@RestController
@RequestMapping("/mobile-service")
@Profile(value="dev")
public class MobileController {
	
	@Autowired
	MobileService mobileService;
	@Value("${message}")
	String message;
	
	@GetMapping("/greet")
	public String greet() {
		return message;
	}
	@PostMapping("/mobiles")
	Mobile addMobile(@RequestBody Mobile mobile){
		return mobileService.addMobile(mobile);
	}
	
	@PutMapping("/mobiles")
	void updateMobile(@RequestBody Mobile mobile){
		mobileService.updateMobile(mobile);
	}
	
	@DeleteMapping("/mobiles")
	void deleteMobile(@PathVariable("mobileid")int mobileId){
		mobileService.deleteMobile(mobileId);
	}
	
	@GetMapping("/mobiles/{mobileid}")
	Mobile getById(@PathVariable("mobileid") int mobileid){
		return mobileService.getById(mobileid);
	}
	
	
	//http://avinash:8081/mobile-service/mobiles
	@GetMapping("/mobiles")
	List<Mobile> getAll(){
		return mobileService.getAll();
	}
	
	//http://avinash:8081/mobile-service/mobiles/brand/realme
	@GetMapping("/mobiles/brand/{brand}")
	List<Mobile> getByBrand(@PathVariable("brand")String brand){
		return mobileService.getByBrand(brand);
	}
	
	//http://avinash:8081/mobile-service/mobiles/model/xt
	@GetMapping("/mobiles/model/{model}")
	List<Mobile> getByModel(@PathVariable("model")String model) {
		return mobileService.getByModel(model);
	}
	
	//http://avinash:8081/mobile-service/mobiles/price/20000
	@GetMapping("/mobiles/price/{price}")
	List<Mobile> getByPrice(@PathVariable("price")double price) {
		return mobileService.getByPrice(price);
	}
	
	//
	@GetMapping("/mobiles/brandvalue/{brand}/modelvalue/{model}")
	List<Mobile> getByModelAndBrand(@PathVariable("brand")String brand,@PathVariable("model")String model) {
		return mobileService.getByModelAndBrand(brand, model);
	}
}
