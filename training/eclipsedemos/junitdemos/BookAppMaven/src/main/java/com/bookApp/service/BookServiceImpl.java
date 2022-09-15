package com.bookApp.service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.bookApp.Repository.BookRepositoryImpl;
import com.bookApp.Repository.IBookRepository;
import com.bookApp.exceptions.BookNotFoundException;
import com.bookApp.exceptions.IdNotFoundException;
import com.bookApp.model.Book;

public class BookServiceImpl implements IBookService {

	IBookRepository bookRepo = new BookRepositoryImpl();

	public Integer addBook(Book book) {
		int bookid=bookRepo.addBook(book);
		return bookid;
	}

	public void updateBook(int bookid, double price) {
		bookRepo.updateBook(bookid, price);

	}

	public void deleteBook(int bookid) {
		bookRepo.deleteBook(bookid);

	}

	public List<Book> getByAuthor(String author) throws BookNotFoundException {
		List<Book> bookByAuthor = bookRepo.getByAuthor(author);
		if (bookByAuthor.isEmpty())
			throw new BookNotFoundException("Book Not found");
		return bookByAuthor.stream().sorted(Comparator.comparing(Book::getTitle)).collect(Collectors.toList());
	}

	public List<Book> getBookByCategory(String category) throws BookNotFoundException {
		List<Book> bookByCategory = bookRepo.getBookByCategory(category);
		if (bookByCategory.isEmpty()) {
			throw new BookNotFoundException("Book Not found");
		}
		return bookByCategory.stream().sorted(Comparator.comparing(Book::getTitle)).collect(Collectors.toList());
	}

	public List<Book> getByLessPrice(double price) throws BookNotFoundException {
		List<Book> bookByPrice = bookRepo.getByLessPrice(price);
		if (bookByPrice.isEmpty()) {
			throw new BookNotFoundException("Book Not found");
		}
		return bookByPrice.stream().sorted(Comparator.comparing(Book::getTitle)).collect(Collectors.toList());
	}

	public Book getById(int bookid) throws IdNotFoundException{
		Book BookById = bookRepo.getById(bookid);
		if (BookById == null) {
			throw new IdNotFoundException("Book Not found");
		}
		return BookById;
	}

}
