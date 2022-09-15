package com.bookApp.client;

import com.bookApp.exceptions.BookNotFoundException;
import com.bookApp.exceptions.IdNotFoundException;
import com.bookApp.exceptions.InvalidDataException;
import com.bookApp.model.Book;
import com.bookApp.service.BookServiceImpl;
import com.bookApp.service.IBookService;

public class Client {

	public static void main(String[] args) {
		IBookService bookService = new BookServiceImpl();                  //Creating object of BookServiceImpl
//		Book book = new Book("cod", "avi", "java", 290);
//		try {
//			System.out.println(bookService.addBook(book));
//		} catch (Exception e1) {
//			e1.printStackTrace();
//		}
		System.out.println("Book By Author"); 
		try {
			bookService.getByAuthor("Ayan").forEach(System.out::println);//filtering By Author
		} catch (BookNotFoundException e) {                              //Handling Exception
			System.out.println(e.getMessage());                          //Printing Exception 
		} catch (InvalidDataException e) {
		
			e.printStackTrace();            //handle Exception and Errors with class Name and more details
		}
		System.out.println("Book By Category");
		try {
			bookService.getBookByCategory("java").forEach(System.out::println); //filtering By Category
		} catch (BookNotFoundException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("Book By price");
		try {
			bookService.getByLessPrice(200).forEach(System.out::println); //Filtering By price
		} catch (BookNotFoundException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("Book By Id");
		try {
			Book bookbyId = bookService.getById(2);                    //Filtering By Id
			System.out.println(bookbyId);
		} catch (IdNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}

}
