package com.sportsapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sportsapp.model.Sports;

@Repository
public interface ISportsRepository extends JpaRepository<Sports, Integer>{

}
