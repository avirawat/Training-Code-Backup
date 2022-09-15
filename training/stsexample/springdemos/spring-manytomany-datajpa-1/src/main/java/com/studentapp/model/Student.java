package com.studentapp.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Student {

	@Id
	@GeneratedValue(generator = "student_gen", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "student_gen", sequenceName = "student_seq", initialValue = 100, allocationSize = 1)
	private Integer studentId;
	@Column(length = 20)
	private String name;
	@Column(length = 20)
	private String type;

	@Column(length = 20)
	private String city;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "student_courses",
				joinColumns = {
						@JoinColumn(name = "student_id")
						}, 
				inverseJoinColumns = {
						@JoinColumn(name = "course_id")
						})

	private Set<Course> courseList;

	public Student(String name, String type, String city, Set<Course> courseList) {
		super();
		this.name = name;
		this.type = type;
		this.city = city;
		this.courseList = courseList;
	}

}
