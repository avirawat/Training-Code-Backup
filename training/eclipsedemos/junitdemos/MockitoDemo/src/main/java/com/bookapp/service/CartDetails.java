package com.bookapp.service;

import java.util.List;

import com.bookapp.exceptions.BookNotFoundException;
import com.bookapp.exceptions.EmptyCartException;
import com.bookapp.model.Book;

public class CartDetails {
	
	ICartService cartService;
	
	public void setCartService(ICartService cartService) {
		this.cartService=cartService;
	}
	public double payBooksInCart() throws EmptyCartException {
		List<Book>bookList=cartService.showCart();
		double totalamount=bookList.stream().mapToDouble(book->book.getPrice()).sum();
		return totalamount;
	}
	public String addToCart(Book book) {
		try {
			cartService.addtoCart(book);
			return "added successfully";
		} catch (BookNotFoundException e) {
			System.out.println(e.getMessage());
		}
		return "book not added";
		
	}
	// true,false exception
	public String removeFromCart(Book book) throws BookNotFoundException {
		boolean result=cartService.removeFromCart(book);
		if(result) 
		return "removed successfully";
		else
		return "book not removed";
	}
	
	public String greet(String name) {
		return "welcome " +name;
	}
}
