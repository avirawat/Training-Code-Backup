package com.hotelapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hotelapp.model.Hotel;

@Service
public interface IHotelService {

	// inbuilt method
	Hotel addHotel(Hotel hotel);

	void updateHotel(Hotel hotel);

	void deleteHotel(int hotelId);

	List<Hotel> getAll();

	Hotel getById(int hotelId);

	// derived queries
	List<Hotel> getByCity(String city);

	List<Hotel> getByType(String type); // veg and no veg

	List<Hotel> getByRating(double rating);

	List<Hotel> getByMenuName(String menuName);

	List<Hotel> getByMenuAndType(String menuName, String menutype);

	List<Hotel> getByCuisine(String cuisine);

	List<Hotel> getByMenuType(String menutype); // starter/dessert

	List<Hotel> getByCuisineAndType(String cuisine, String type); // chinese veg

	List<Hotel> getByMenuNameLessPrice(String menuName, double price);

}
