package com.acheron.training;

import java.util.Arrays;

import com.acheron.training.exceptions.*;

public class StudentDetails {
	public int totalMarks(int marks1,int marks2,int marks3) {
		return marks1+marks2+marks3;
	}
	public int negMarks(int marks1,int marks2,int marks3) throws InvalidNumException {
		if(marks1<0 || marks2<0 || marks3<0) {
			throw new InvalidNumException("Invalid markber");
		}
		else {
			return marks1+marks2+marks3;
		}
	}
	public int marksLimit(int marks1,int marks2,int marks3) throws InvalidNumException {
		if(marks1>100 || marks2>100 || marks3>100) {
			throw new InvalidNumException("Invalid markber");
		}
		else {
			return marks1+marks2+marks3;
		}
	}
	public String getGrades(int[] marks) {
	//System.out.println(marks[0]);
	int sum=0;
	float average=0;
	if(marks!=null) {
		Arrays.sort(marks);
		for(int mark:marks) {
			if(mark<40)
				return "fail";
			if(mark>100) {
				return "wrong value";
			}
			sum+=mark;
		}
		average=sum/marks.length;
	}
	
	if(average>90 && average<=100) {
		return "A";
	}
	else if(average>80 && average<=90) {
		return "B";
	}
	else if(average>70 && average>=80) {
		return"C";
	}
	else if(average>40 && average<=70) {
		return "D";
	}
	else {
		return "marks not initialized";
	}
}
}
