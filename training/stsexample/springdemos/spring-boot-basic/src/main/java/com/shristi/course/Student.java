package com.shristi.course;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Student {

	@Autowired
	ICourses backendDev;

	@Autowired
	ICourses fullstackDev;

	@Autowired
	ICourses webDev;

	public List<String> showCourses(String type) {
		List<String> allCourse = new ArrayList<>();
		if (type.equals("backend")) {
			allCourse = backendDev.printDetails();
		}
		if (type.equals("fullstack")) {
			allCourse = fullstackDev.printDetails();
		}
		if (type.equals("webdev")) {
			allCourse = webDev.printDetails();
		}
		return allCourse.stream().sorted().toList();
	}
}
