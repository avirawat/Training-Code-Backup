package com.acheron.newtests.greet;


import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
@Tag("greet")
class GreetTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	@DisplayName("Testing Null")
	void testNull() {
		List<String> myList = null;
		assertNull(myList); // test case will succeed
	}
	@Test
	@DisplayName("Testing String reference")
	void testSame() {
		String username="Priya";
		assertSame(username,"Priya","refrence are not same");
	}
	@Test
	@DisplayName("Testing String literals")
	void testEquality() {
		String username="Priya";
		
		assertSame(username,"Priya","literals are not same");
	}
	
	@Test
	@DisplayName("Testing not null")
	void testArray() {
		int[] arr1= {10,20};
		int[] arr2= {10,20};
		assertArrayEquals(arr1,arr2,"both are not equal");
	}

	@Test
	@DisplayName("Testing not Null")
	void testNotNull() {
		List<String> myList = new ArrayList<>();
		assertNotNull(myList);
	}

}
