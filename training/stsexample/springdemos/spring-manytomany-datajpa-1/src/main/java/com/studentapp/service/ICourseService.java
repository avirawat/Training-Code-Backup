package com.studentapp.service;

import java.util.List;

import com.studentapp.model.Course;
import com.studentapp.model.Student;

public interface ICourseService {
	
	void addCourse(Course course);
	void updateCourse(Course course);
	void deleteCourse(int courseId);
	List<Course> getAll();
    Course getById(int courseId);
	// derived queries
	List<Course> getCoursesByFee(double fee);
	List<Course>getStudentByName(String courseName);
}
