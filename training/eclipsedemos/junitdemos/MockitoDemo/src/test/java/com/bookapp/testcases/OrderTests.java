package com.bookapp.testcases;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
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
import com.bookapp.exceptions.NoDiscountApplicableException;
import com.bookapp.model.Book;
import com.bookapp.service.IBookService;
import com.bookapp.service.OrderDetails;

@ExtendWith(MockitoExtension.class)
@RunWith(MockitoJUnitRunner.class)
class OrderTests {

	@Mock
	IBookService bookService;

	@InjectMocks
	OrderDetails details;

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
		details=new OrderDetails();
		details.setBookService(bookService);

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
	@DisplayName("Testing with proper list")
	void testShowBooks() throws BookNotFoundException {
		when(bookService.getByAuthor("kathy")).thenReturn(Arrays.asList(book1,book2));
		List<Book> bookByAuhtor=details.showBook("kathy");
		assertEquals(2,bookByAuhtor.size(),"not equal");
	}
	
	@Test
	@DisplayName("Testing with empty list")
	void testEmptyBooks() throws BookNotFoundException {
		when(bookService.getByAuthor("priya")).thenReturn(new ArrayList<Book>());
		//List<Book> bookByAuhtor=details.showBook("priya");
		//assertEquals(3,bookByAuhtor.size(),"not equal");
		assertThrows(BookNotFoundException.class,()->details.showBook("priya"));
	}
	
	@Test
	@DisplayName("Testing with null list")
	void testNullList() throws BookNotFoundException {
		when(bookService.getByAuthor("priya")).thenReturn(null);
		assertDoesNotThrow(() -> details.showBook("priya"));
	}
	
	@Test
	@DisplayName("Testing with 4 books")
	void testTwoBooks() throws BookNotFoundException {
		when(bookService.getByAuthor("kathy")).thenReturn(Arrays.asList(book1,book2,book3,book4));
		List<Book> bookByAuhtor=details.showBook("kathy");
		assertEquals(4,bookByAuhtor.size(),"not equal");
	}
	
	@Test
	@DisplayName("Testing ordered book")
	void testOrderedBooks() throws BookNotFoundException {
		when(bookService.getById(1)).thenReturn(book1);
		String book=details.orderBook(1);
		//System.out.println(book);
		assertEquals("java order success",book,"not equal");
	}
	
	@Test
	@DisplayName("Testing book null")
	void testNullBooks() throws BookNotFoundException {
		when(bookService.getById(1)).thenReturn(null);
		assertThrows(BookNotFoundException.class,()->details.orderBook(1));
	}
	@Test
	@DisplayName("Testing discount")
	void testDiscountOnBooks() throws NoDiscountApplicableException {
		when(bookService.getByLessPrice(900)).thenReturn(Arrays.asList(book3));
		double bookByLessPrice=details.getOrderByDiscount(900, 500);
		//assertThrows(NoDiscountApplicableException.class,()->details.getOrderByDiscount();
		assertEquals(400,bookByLessPrice,"not equal");
	}
	
	
}
