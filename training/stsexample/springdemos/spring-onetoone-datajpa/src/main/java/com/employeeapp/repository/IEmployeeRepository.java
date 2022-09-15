package com.employeeapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.employeeapp.model.Employee;

@Repository
public interface IEmployeeRepository extends JpaRepository<Employee,Integer> {
	
	//derived query
	List<Employee> findByDesignation(String designation);
	List<Employee> findByAddressCity(String city);
	
	// custom queryfrom Employee e inner join e.address a where a.city=?1 and e.designation=?2
	@Query("from Employee e inner join e.address a where a.city=?1 and e.designation=?2")
	List<Employee> findByCityAndDesignation(String city,String designation);
	
	@Query(value="select * from Employee e inner join address a on e.address_id=a.address_id where a.city=?",nativeQuery=true)
	List<Employee> findByCity(String city);
	
	@Query(name="findbySalCity")
	List<Employee> findByLessSalaryCity(double salary,String city);
}
