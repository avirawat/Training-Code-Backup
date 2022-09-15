package com.mobileapp.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mobileapp.exception.MobileNotFoundException;
import com.mobileapp.model.Mobile;

@Service
public interface MobileService {

	Mobile addMobile(Mobile mobile);

	void updateMobile(Mobile mobile);

	void deleteMobile(int mobileId);

	Mobile getById(int mobileid) throws MobileNotFoundException;

	List<Mobile> getAll();

	List<Mobile> getByBrand(String brand) throws MobileNotFoundException;

	List<Mobile> getByModel(String model) throws MobileNotFoundException;
	
	List<Mobile> getByPrice(double price) throws MobileNotFoundException;

	List<Mobile> getByModelAndBrand(String brand, String model) throws MobileNotFoundException;
}
