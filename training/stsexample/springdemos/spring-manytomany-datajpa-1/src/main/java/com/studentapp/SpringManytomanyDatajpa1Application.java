package com.studentapp;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.studentapp.model.Course;
import com.studentapp.model.Student;
import com.studentapp.service.ICourseService;
import com.studentapp.service.IStudentService;

@SpringBootApplication
public class SpringManytomanyDatajpa1Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringManytomanyDatajpa1Application.class, args);
	}

	@Autowired
	IStudentService studentService;
	@Autowired
	ICourseService courseService;

	@Override
	public void run(String... args) throws Exception {
		// add 1
//		Course course1 = new Course("Java", "30 days", 2500.0);
//		courseService.addCourse(course1);
//		Course course2 = new Course("Python", "30 days", 1400.0);
//		courseService.addCourse(course2);
//		Course course3 = new Course("Spring", "10 days", 3500.0);
//		courseService.addCourse(course3);
//		List<Course> courseList = Arrays.asList(course1, course2, course3);
//		Set<Course> courseSet = new HashSet<>(courseList);
//		Student student = new Student("Avinash", "btech", "Hyd", courseSet);
//		studentService.addStudent(student);

		// add 2
//		Course course1 = new Course("Angular", "50 days", 7500.0);
//		courseService.addCourse(course1);
//		Course course2 = new Course("React", "35 days", 1300.0);
//		courseService.addCourse(course2);
//		Course course3 = new Course("Js", "30 days", 1500.0);
//		courseService.addCourse(course3);
//		List<Course> courseList = Arrays.asList(course1, course2, course3);
//		Set<Course> courseSet = new HashSet<>(courseList);
//		Student student = new Student("Ayan", "BE", "Banglore", courseSet);
//		studentService.addStudent(student);

		System.out.println("*********All student with courses********");
		studentService.getAll().forEach(System.out::println);

		System.out.println("*********Add Courses By Fetching to Other Student********");
		Course course1 = courseService.getById(100);
		Course course2 = courseService.getById(101);
		Set<Course> courseList = new HashSet<>(Arrays.asList(course1, course2));
		Student student = new Student("Naveen", "BE", "Cbe", courseList);
		// studentService.addStudent(student);

		System.out.println("*********Get By city********");
		studentService.getByCity("Hyd").forEach(System.out::println);

		System.out.println("*********Get By CourseName********");
		studentService.getByCourseName("Java").forEach(System.out::println);

		System.out.println("*********Get Coutrse By fee********");
		courseService.getCoursesByFee(2000).forEach(System.out::println);

		System.out.println("*********Get By Student Name********");
		courseService.getStudentByName("Avinash").forEach(System.out::println);

		System.out.println("-------Get By Student----");
		courseService.getStudentByName("Avinash").stream().forEach((value) -> {
			System.out.println(value.getCourseName());
			System.out.println(value.getDuration());
			System.out.println(value.getFee());
			value.getStudentList().forEach((s) -> {
				System.out.println(s.getCity());
			});

		});

		
		System.out.println("-------Update Student----");
		Student student1 = studentService.getById(102);
		student1.setName("Naveen Kumar");
		student1.setCity("Coimbatore");
		studentService.updateStudent(student1);
	}

}
