package com.studentapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.studentapp.model.Course;

@Repository
public interface ICourseRepository extends JpaRepository<Course,Integer> {

	List<Course>findByFeeLessThan(double fee);
	
	@Query("from Course c inner join c.studentList s where s.city=?1")
	List<Course>findByCity(String city);
	
	@Query("from Course c inner join c.studentList s where s.name=?1")
	List<Course>findByStudentName(String name);
	
}
