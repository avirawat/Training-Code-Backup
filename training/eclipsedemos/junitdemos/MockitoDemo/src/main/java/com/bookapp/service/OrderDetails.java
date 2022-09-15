package com.bookapp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.bookapp.exceptions.BookNotFoundException;
import com.bookapp.exceptions.NoDiscountApplicableException;
import com.bookapp.model.Book;

public class OrderDetails {

	IBookService bookService;

	public List<Book> showBook(String author) throws BookNotFoundException {
		List<Book> booksByAuthor = bookService.getByAuthor(author);
		List<Book> finalBooks = new ArrayList<Book>();
		if (booksByAuthor != null) {
			if (booksByAuthor.isEmpty()) {
				throw new BookNotFoundException("book not available");
			}
			finalBooks = booksByAuthor.stream().limit(4).collect(Collectors.toList());
		}
		return finalBooks;
	}

	public String orderBook(int bookid) throws BookNotFoundException {
		Book book = bookService.getById(bookid);
		// System.out.println(book);
		if (book == null) {
			throw new BookNotFoundException("Book not found");
		}
		return book.getTitle() + " order success";
	}

	public double getOrderByDiscount(double price, int discountamount) throws NoDiscountApplicableException {
		List<Book> bookList = bookService.getByLessPrice(price);
		if(bookList.isEmpty()) {
			throw new NoDiscountApplicableException("NO discount Applicable");
		}
		double totalamount = 0.0;
//		for (Book book : bookList) {
//			double newprice = book.getPrice() - discountamount;
//			totalamount += newprice;
//		}
		totalamount+=bookList.stream().mapToDouble(book->book.getPrice()-discountamount).sum();
		return totalamount;
	}

	public IBookService getBookService() {
		return bookService;
	}

	public void setBookService(IBookService bookService) {
		this.bookService = bookService;
	}

}
