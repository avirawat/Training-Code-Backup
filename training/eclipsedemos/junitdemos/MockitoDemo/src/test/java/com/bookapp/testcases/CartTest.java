package com.bookapp.testcases;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import com.bookapp.exceptions.BookNotFoundException;
import com.bookapp.exceptions.EmptyCartException;
import com.bookapp.model.Book;
import com.bookapp.service.CartDetails;
import com.bookapp.service.ICartService;

@ExtendWith(MockitoExtension.class)
@RunWith(MockitoJUnitRunner.class)
class CartTest {

	@Mock
	ICartService cartService;

	@InjectMocks
	CartDetails details;

	List<Book> bookList;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}
     
	Book book1,book2,book3,book4,book5;
	
	@BeforeEach
	void setUp() throws Exception {
		details=new CartDetails();
		details.setCartService(cartService);

		book1=new Book("java","kathy",1900,1);
	    book2=new Book("Spring","kathy",800,2);
		book3=	new Book("javac","kathy",900,3);
		book4=	new Book("Leadership","kathy",1800,4);
		book5=	new Book("miracle","Hal",500,5);
		bookList=Arrays.asList(book1,book2,book3,book4,book5);
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	@DisplayName("Testing with pay book empty")
	void testPayBooksEmpty() throws EmptyCartException {
		when(cartService.showCart()).thenThrow(EmptyCartException.class);
		assertThrows(EmptyCartException.class,()->details.payBooksInCart());
	}
	@Test
	@DisplayName("Testing pay books")
	void testPayBooks() throws EmptyCartException {
		doReturn(Arrays.asList(book2,book3,book4,book5)).when(cartService).showCart();
		double totalamount=details.payBooksInCart();
		assertEquals(4000,totalamount,"not equal");
	}
	@Test
	@DisplayName("Testing Add to cart")
	void testAddToCart() throws BookNotFoundException {
		//use do nothing for methods
		doNothing().when(cartService).addtoCart(book1);
		//testing the method in the class under test
		assertEquals("added successfully",details.addToCart(book1));
	}
	@Test
	@DisplayName("Testing Add to cart empty")
	void testAddToCartEmpty() throws BookNotFoundException {
		// use with void function that throw exception
		doThrow(BookNotFoundException.class).when(cartService).addtoCart(book1);
		assertEquals("book not added",details.addToCart(book1));
	}
	
	@Test
	@DisplayName("Testing remove from cart -true")
	void testRemoveFromCart() throws BookNotFoundException {
		when(cartService.removeFromCart(book1)).thenReturn(true);
		assertEquals("removed successfully",details.removeFromCart(book1),"same");
	}
	@Test
	@DisplayName("Testing remove from cart -false")
	void testFalseRemoveFromCart() throws BookNotFoundException {
		when(cartService.removeFromCart(book1)).thenReturn(false);
		assertEquals("book not removed",details.removeFromCart(book1),"same");
	}
	@Test
	@DisplayName("Testing remove from cart exception")
	void testErrorRemoveFromCart() throws BookNotFoundException {
		when(cartService.removeFromCart(book1)).thenThrow(BookNotFoundException.class);
		assertThrows(BookNotFoundException.class,()->details.removeFromCart(book1));
	}
	
}
