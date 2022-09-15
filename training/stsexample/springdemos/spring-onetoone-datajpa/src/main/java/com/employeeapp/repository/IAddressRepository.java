package com.employeeapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employeeapp.model.Address;

@Repository
public interface IAddressRepository extends JpaRepository<Address,Integer> {
	
	Address findByEmployeeName(String name);
}
