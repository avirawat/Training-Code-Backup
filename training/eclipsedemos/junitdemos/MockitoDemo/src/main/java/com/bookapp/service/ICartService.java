package com.bookapp.service;

import java.util.List;

import com.bookapp.exceptions.BookNotFoundException;
import com.bookapp.exceptions.EmptyCartException;
import com.bookapp.model.Book;

public interface ICartService {
	List<Book> showCart() throws EmptyCartException;
	void addtoCart(Book book) throws BookNotFoundException;
	boolean removeFromCart(Book book) throws BookNotFoundException;
}
