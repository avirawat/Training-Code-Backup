package com.hotelapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hotelapp.model.Menu;

@Repository
public interface IMenuRepository extends JpaRepository<Menu, Integer> {

	//List<Menu> findByHotelName(String hotelName);
	
	@Query("from Menu m inner join m.hotel h where h.name=?1")
	List<Menu> findByHotel(String hotelName);
	
	@Query("from Menu m inner join m.hotel h where h.name=?1 and m.cuisine=?2")
	List<Menu> findByHotelAndCuisine(String hotelName,String cuisine);
}
