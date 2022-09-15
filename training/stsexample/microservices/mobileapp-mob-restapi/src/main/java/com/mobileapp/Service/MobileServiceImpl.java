package com.mobileapp.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mobileapp.exception.MobileNotFoundException;
import com.mobileapp.model.Mobile;
import com.mobileapp.repository.IMobileRepository;

@Service
public class MobileServiceImpl implements MobileService {

	@Autowired
	IMobileRepository mobileRepository;
	

	@Override
	public Mobile addMobile(Mobile mobile) {
		return mobileRepository.save(mobile);
	}

	@Override
	public void updateMobile(Mobile mobile) {
		mobileRepository.save(mobile);
		
	}

	@Override
	public void deleteMobile(int mobileId) {
		mobileRepository.deleteById(mobileId);
		
	}

	@Override
	public Mobile getById(int mobileid) throws MobileNotFoundException {
		return mobileRepository.findById(mobileid).get();
	}

	@Override
	public List<Mobile> getAll() {
		return mobileRepository.findAll();
	}

	@Override
	public List<Mobile> getByBrand(String brand) throws MobileNotFoundException {
		return mobileRepository.findByBrand(brand);
	}

	@Override
	public List<Mobile> getByModel(String model) throws MobileNotFoundException {
		return mobileRepository.findByModel(model);
	}

	@Override
	public List<Mobile> getByModelAndBrand(String brand, String model) throws MobileNotFoundException {
		return mobileRepository.findByModelAndBrand(brand, model);
	}

	@Override
	public List<Mobile> getByPrice(double price) throws MobileNotFoundException {
		return mobileRepository.findByPriceLessThan(price);
	}

	
}
