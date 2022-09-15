package com.hotelapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotelapp.model.Menu;
import com.hotelapp.repository.IMenuRepository;

@Service
public class MenuServiceImpl implements IMenuService{

	@Autowired
	IMenuRepository menuRepository;
	@Override
	public List<Menu> findByHotel(String hotelName) {
	 return menuRepository.findByHotel(hotelName);
	}

	@Override
	public List<Menu> findByHotelAndCuisine(String hotelName, String cuisine) {
		return menuRepository.findByHotelAndCuisine(hotelName, cuisine);
	}

}
