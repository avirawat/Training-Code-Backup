package com.shristi;

import java.util.List;
//import java.util.stream.Stream;
import java.util.stream.Stream;

import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.shristi.course.ICourses;
import com.shristi.course.Student;

@SpringBootApplication
public class SpringBootBasicApplication implements CommandLineRunner {

	// private static final ListableBeanFactory context = null;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootBasicApplication.class, args);
	}

	@Autowired
	ApplicationContext context;

//	@Autowired
//	Employee employee;

	@Autowired
	Student student;

	@Override
	public void run(String... args) throws Exception {
//	
//		String[] beanNames=context.getBeanDefinitionNames();
//		Stream.of(beanNames).forEach(System.out::println);
		// System.out.println(context.getBean(Employee.class));
		student.showCourses("backend").forEach(System.out::println);
		student.showCourses("fullstack").forEach(System.out::println);
		student.showCourses("webdev").forEach(System.out::println);

	}

}
