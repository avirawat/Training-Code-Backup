package com.bookapp.main;

import java.util.List;

import com.bookapp.exceptions.BookNotFoundException;
import com.bookapp.model.Book;
import com.bookapp.service.OrderDetails;

public class Main {

	public static void main(String[] args) throws BookNotFoundException{
		
		OrderDetails details=new OrderDetails();
		List<Book> bookList=details.showBook("kathy");
		System.out.println(bookList);
	}

}
