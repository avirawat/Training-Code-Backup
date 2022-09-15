package com.hotelapp.service;

import java.util.List;

import org.springframework.stereotype.Service;


import com.hotelapp.model.Menu;


public interface IMenuService {
	
	List<Menu> findByHotel(String hotelName);
	
	List<Menu> findByHotelAndCuisine(String hotelName,String cuisine);
}
