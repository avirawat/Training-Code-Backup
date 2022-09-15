package com.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.security.model.AppUsers;

@Repository
public interface AppUsersRepository extends JpaRepository<AppUsers, Integer>{
	
	AppUsers findByUsername(String userName);
}
