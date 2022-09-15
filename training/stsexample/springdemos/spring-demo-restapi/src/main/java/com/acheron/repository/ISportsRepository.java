package com.acheron.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.acheron.model.Sports;
import com.acheron.model.SportView;

@Repository
public interface ISportsRepository extends JpaRepository<Sports,Integer> {
	
	@Query(value="select * from sportview",nativeQuery=true)
	List<SportView> findAllSports();
}
