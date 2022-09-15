package com.employeeapp.service;

import org.springframework.stereotype.Service;

import com.employeeapp.model.Address;

@Service
public interface IAddressService {

	Address getByEmployeeName(String name);
	
}
