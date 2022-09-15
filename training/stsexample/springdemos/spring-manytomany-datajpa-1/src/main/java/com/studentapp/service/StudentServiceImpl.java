package com.studentapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studentapp.model.Student;
import com.studentapp.repository.IStudentRepository;

@Service
public class StudentServiceImpl implements IStudentService{

	@Autowired
	IStudentRepository studentRepository;
	
	@Autowired
	public void setStudentRepository(IStudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}

	@Override
	public Student addStudent(Student student) {
		return studentRepository.save(student);
	}

	@Override
	public void updateStudent(Student student) {
		studentRepository.save(student);
		
	}

	@Override
	public void deleteStudent(int studentId) {
		studentRepository.deleteById(studentId);
		
	}

	@Override
	public List<Student> getAll() {
		return studentRepository.findAll();
	}

	@Override
	public Student getById(int studentId) {
		return studentRepository.findById(studentId).get();
	}

	@Override
	public List<Student> getByCity(String city) {
		return studentRepository.findByCity(city);
	}

	@Override
	public List<Student> getByCourseName(String courseName) {
		return studentRepository.findByCourseName(courseName);
	}

}
