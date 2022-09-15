package com.acheron.mytests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import com.acheron.training.StudentDetails;
import com.acheron.training.exceptions.*;

@RunWith(JUnitPlatform.class)
class StudentTest {

	StudentDetails studentdetails;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		studentdetails = new StudentDetails();
	}

	@AfterEach
	void tearDown() throws Exception {
		studentdetails = null;
	}

	@Test
	@DisplayName("Testing positive marks")
	void testTotalMarks() {
		assertEquals(250, studentdetails.totalMarks(90, 80, 80), "not correct");
	}

	@Test
	@DisplayName("Testing negative marks")
	void testNegMarks() throws InvalidNumException {
		int[] marks=new int[] {15,-50};
		assertEquals("fail", studentdetails.getGrades(marks), "not correct");
	}
	

	@Test
	@DisplayName("Testing marks <100")
	void testGreaterMarks() throws InvalidNumException {
		// int[] marks=new int[] {110,92,90};
		assertThrows(InvalidNumException.class, () -> {
			studentdetails.marksLimit(101, 50, 60);
		});
	}

	@Test
	@DisplayName("Testing of Grades")
	void testAgrades() {
		int[] marks = new int[] { 90, 92, 90 };
		assertEquals("B", studentdetails.getGrades(marks), "not equal");
	}

	@Test
	void testBgrades() {
		int[] marks = new int[] { 90, 92, 90 };
		assertEquals("B", studentdetails.getGrades(marks), "not equal");
	}

	@Test
	void testCgrades() {
		int[] marks = new int[] { 90, 92, 90 };
		assertEquals("B", studentdetails.getGrades(marks), "not equal");
	}

	@Test
	void testDgrades() {
		int[] marks = new int[] { 90, 92, 90 };
		assertEquals("B", studentdetails.getGrades(marks), "not equal");
	}

	@Test
	@DisplayName("Testing marks >100")
	void testGreatMarks() throws InvalidNumException {
		int[] marks = new int[] { 110, 92, 90 };
		assertEquals("wrong value", studentdetails.getGrades(marks), "not equal");
	}

	@Test
	@DisplayName("Testing for Array empty")
	void testOneNull() {
		int[] marks = new int[0];
		System.out.println(marks.length);
		//assertDoesNotThrow(()->studentdetails.getGrades(marks),"Array is null");
//		Assertions.assertThrows(NullPointerException.class,()->{
//			studentdetails.getGrades(marks);
//		});
	}
	@Test
	@DisplayName("Testing for Array null")
	void testNull() {
		int[] marks =null;
		assertEquals("marks not initialized", studentdetails.getGrades(marks), "Not null");
	}
	
}
