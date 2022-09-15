package com.studentapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.studentapp.model.Student;

@Repository
public interface IStudentRepository extends JpaRepository<Student,Integer> {

	List<Student> findByCity(String city);
	
	@Query("from Student s inner join s.courseList c where c.courseName=?1")
	List<Student> findByCourseName(String courseName);
}
