package com.hotelapp.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hotelapp.model.Hotel;

@Repository
public interface IHotelappRepository extends JpaRepository<Hotel, Integer> {

	// derived
	List<Hotel> findByCity(String city,Sort sort);

	List<Hotel> findByRating(double rating,Sort sort);

	List<Hotel> findByType(String type,Sort sort);

	List<Hotel> findByMenuListMenuName(String menuName);

	// custom Query

	@Query("from Hotel h inner join h.menuList m where m.menuName=?1 and m.menuType=?2")
	List<Hotel> findByMenuNameAndType(String menuName, String menutype);

	@Query("from Hotel h inner join h.menuList m where m.cuisine=?1")
	List<Hotel> findByCuisine(String cuisine);

	@Query("from Hotel h inner join h.menuList m where m.menuType=?1")
	List<Hotel> findByMenuType(String menutype);

	@Query("from Hotel h inner join h.menuList m where m.cuisine=?1 and h.type=?2")
	List<Hotel> findByCuisineAndType(String cuisine, String type);

	@Query("from Hotel h inner join h.menuList m where m.menuName=?1 and m.price<=?2")
	List<Hotel> findByMenuNameLessPrice(String menuName, double price);
}
