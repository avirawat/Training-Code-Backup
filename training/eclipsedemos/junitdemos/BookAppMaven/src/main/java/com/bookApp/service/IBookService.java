package com.bookApp.service;

import java.util.List;

import com.bookApp.exceptions.BookNotFoundException;
import com.bookApp.exceptions.IdNotFoundException;
import com.bookApp.model.Book;

public interface IBookService {
	Integer addBook(Book book);
	void updateBook(int bookid,double price);
	void deleteBook(int bookid);
	
	List<Book> getByAuthor(String author) throws BookNotFoundException;
	List<Book> getBookByCategory(String category) throws BookNotFoundException;
	List<Book> getByLessPrice(double price) throws BookNotFoundException;
	Book getById(int bookid) throws IdNotFoundException;
}
