package com.studentapp.service;

import java.util.List;

import com.studentapp.model.Student;

public interface IStudentService {
	

	// inbuilt method
	Student addStudent(Student student);

	void updateStudent(Student student);

	void deleteStudent(int studentId);

	List<Student> getAll();

	Student getById(int studentId);
	// derived queries
	List<Student> getByCity(String city);
	List<Student> getByCourseName(String courseName);
}
