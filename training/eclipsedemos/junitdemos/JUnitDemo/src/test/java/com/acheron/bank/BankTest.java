package com.acheron.bank;

//import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.acheron.training.Bank;
import com.acheron.training.exceptions.InsufficientBalanceException;
import com.acheron.training.exceptions.LimitExceededException;
import com.acheron.training.exceptions.NegativeAmountException;
import com.acheron.training.exceptions.PanNotFoundException;
import com.acheron.training.exceptions.ZeroAmountException;

class BankTest {

	Bank bank;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		bank = new Bank(10000);
	}

	@AfterEach
	void tearDown() throws Exception {
		bank = null;
	}

	@Test
	@DisplayName("Insufficient Balance")
	void testLowBalance() throws InsufficientBalanceException, LimitExceededException,PanNotFoundException{
		assertEquals(7000, bank.withdraw(3000));
	}

	@Test
	@DisplayName("Exceed Limit")
	void testLimitExceed() throws LimitExceededException {
		assertThrows(LimitExceededException.class, () -> {
			bank.withdraw(8000);
		});
	}

	@Test
	@DisplayName(" Check Zero Balance")
	void testGetBalance() throws ZeroAmountException {
		assertDoesNotThrow(() -> bank.getBalance(), "balance is more than zero");
	}

	@Test
	@DisplayName("Deposit Amount")
	void testDeposit() throws ZeroAmountException,NegativeAmountException {
		assertEquals(15000, bank.deposit(5000));
	}
	@Test
	@DisplayName("penality checker")
	void testPanality() throws InsufficientBalanceException {
		assertDoesNotThrow(() -> bank.penality(), "No penality");
	}
	@Test
	@DisplayName("negative Value")
	void testNegative() throws NegativeAmountException {
		assertDoesNotThrow(() -> bank.deposit(80), "value are positive");
	}
	@Test
	@DisplayName("Pan checker")
	void testCheckPan() throws PanNotFoundException {
		assertDoesNotThrow(() -> bank.withdraw(5000), "Pan avaialable");
	}

}
