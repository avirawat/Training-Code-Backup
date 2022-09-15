package com.shristi.scope;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
@PropertySource("classpath:application.properties")
public class Course {
	
	private String courseName;
	private int courseId;
	private double cost;
	
	private Trainer trainer;
	
	public String getCourseName() {
		return courseName;
	}
	@Value("${course.courseName}")
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public int getCourseId() {
		return courseId;
	}
	@Value("${course.courseId}")
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public double getCost() {
		return cost;
	}
	@Value("${course.courseCost}")
	public void setCost(double cost) {
		this.cost = cost;
	}
	
	
	public Trainer getTrainer() {
		return trainer;
	}
	@Autowired
	public void setTrainer(Trainer trainer) {
		this.trainer = trainer;
	}
	@Override
	public String toString() {
		return "Course [courseName=" + courseName + ", courseId=" + courseId + ", cost=" + cost + ", trainer=" + trainer
				+ "]";
	}
	
	
	
	
}
