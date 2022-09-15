package com.hotelapp.service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hotelapp.model.Hotel;
import com.hotelapp.repository.IHotelappRepository;

@Service
@Transactional
public class HotelServiceImpl implements IHotelService {

	IHotelappRepository hotelRepository;

	@Autowired
	public void setHotelRepository(IHotelappRepository hotelRepository) {
		this.hotelRepository = hotelRepository;
	}

	@Override
	public Hotel addHotel(Hotel hotel) {
		return hotelRepository.save(hotel);
	}

	@Override
	public void updateHotel(Hotel hotel) {
		hotelRepository.save(hotel);

	}

	@Override
	public void deleteHotel(int hotelId) {
		hotelRepository.deleteById(hotelId);

	}

	@Override
	public List<Hotel> getAll() {
		Sort sort=Sort.by(Sort.Direction.ASC, "name");
		return hotelRepository.findAll();
	}

	@Override
	@Transactional
	public Hotel getById(int hotelId) {
		Hotel newHotel=new Hotel();
		newHotel=hotelRepository.getById(hotelId);
		return newHotel;

	}

	@Override
	public List<Hotel> getByCity(String city) {
		Sort sort=Sort.by(Sort.Direction.ASC,"type","name");
		return hotelRepository.findByCity(city,sort).stream().sorted(Comparator.comparing(Hotel::getName))
				.collect(Collectors.toList());
	}

	@Override
	public List<Hotel> getByType(String type) {
		Sort sort=Sort.by(Sort.Direction.ASC,"rating","name");
		return hotelRepository.findByType(type,sort);
	}

	@Override
	public List<Hotel> getByRating(double rating) {
		Sort sort=Sort.by(Sort.Direction.ASC,"city","name");
		return hotelRepository.findByRating(rating,sort);

	}

	@Override
	public List<Hotel> getByMenuName(String menuName) {
		return hotelRepository.findByMenuListMenuName(menuName).stream().sorted(Comparator.comparing(Hotel::getName))
				.collect(Collectors.toList());
	}

	@Override
	public List<Hotel> getByMenuAndType(String menuName, String type) {
		return hotelRepository.findByMenuNameAndType(menuName, type).stream()
				.sorted(Comparator.comparing(Hotel::getName)).collect(Collectors.toList());
	}

	@Override
	public List<Hotel> getByCuisine(String cuisine) {
		return hotelRepository.findByCuisine(cuisine).stream().sorted(Comparator.comparing(Hotel::getName))
				.collect(Collectors.toList());
	}

	@Override
	public List<Hotel> getByMenuType(String menutype) {
		return hotelRepository.findByMenuType(menutype).stream().sorted(Comparator.comparing(Hotel::getName))
				.collect(Collectors.toList());
	}

	@Override
	public List<Hotel> getByCuisineAndType(String cuisine, String type) {
		return hotelRepository.findByCuisineAndType(cuisine, type).stream().sorted(Comparator.comparing(Hotel::getName))
				.collect(Collectors.toList());
	}

	@Override
	public List<Hotel> getByMenuNameLessPrice(String menuName, double price) {
		return hotelRepository.findByMenuNameLessPrice(menuName, price).stream()
				.sorted(Comparator.comparing(Hotel::getName)).collect(Collectors.toList());
	}

}
