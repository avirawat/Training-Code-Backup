package com.studentapp.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Course {
	@Id
	@GeneratedValue(generator = "course_gen", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "course_gen", sequenceName = "course_seq", initialValue = 100, allocationSize = 1)
	private Integer courseId;

	@Column(name = "coursename", length = 20)
	private String courseName;

	private String duration;

	private double fee;
	@ManyToMany(mappedBy = "courseList",fetch = FetchType.EAGER)
	private Set<Student> studentList;

	public Course(String courseName, String duration, double fee) {
		super();
		this.courseName = courseName;
		this.duration = duration;
		this.fee = fee;

	}

	@Override
	public String toString() {
		return "Course [courseId=" + courseId + ", courseName=" + courseName + ", duration=" + duration + ", fee=" + fee
				+ "]";
	}
	
}
