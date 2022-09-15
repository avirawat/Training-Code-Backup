package com.mobileapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mobileapp.exception.MobileNotFoundException;
import com.mobileapp.model.Mobile;

@Repository
public interface IMobileRepository extends JpaRepository<Mobile,Integer> {

	List<Mobile> findByBrand(String brand) throws MobileNotFoundException;

	List<Mobile> findByModel(String model) throws MobileNotFoundException;
	
	List<Mobile> findByPriceLessThan(double price) throws MobileNotFoundException;

	List<Mobile> findByModelAndBrand(String brand, String model) throws MobileNotFoundException;
}
