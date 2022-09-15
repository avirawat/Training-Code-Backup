package com.acheron.newtests;

//import static org.junit.jupiter.api.Assertions.fails;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import com.acheron.training.Calculator;

@RunWith(JUnitPlatform.class)
class CalculatorTest {

	Calculator calc;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.out.println("before all test Cases");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		System.out.println("after all test Cases");
	}

	@BeforeEach
	void setUp() throws Exception {
		//create a new instance of calculator
		calc=new Calculator();
	}
	@Test
	@DisplayName("Testing Sum")
	void testSum() {
		System.out.println("inside sum test case");
		int actualResult=calc.sum(10, 20);
		assertEquals(30, actualResult,"not correct");
	}
	@Test
	@DisplayName("Testing product")
	void tesProduct() {
		System.out.println("inside product test case");
		int productResult=calc.product(10, 20);
		assertEquals(200, productResult,"not correct");
	}
	@Test
	@DisplayName("Testing name")
	void testGreet() {
		assertEquals("WELCOME AVINASH",calc.greet("avinash"),"not same");
	}
	@AfterEach
	void tearDown() throws Exception {
		System.out.println("set up");
		calc=null;
	}


}
