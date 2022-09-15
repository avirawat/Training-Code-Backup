package com.bookApp.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bookApp.exceptions.BookNotFoundException;
import com.bookApp.model.Book;

public class BookRepositoryImpl implements IBookRepository {

	static Connection connection;

	public Integer addBook(Book book) throws Exception {                    //adding Book
		connection = BookDAO.openConnection();												  //Opening Connection
		String insertQuery = "insert into book(title,author,category,price) values(?,?,?,?)"; // insert query
		PreparedStatement statement = null;  //interface is a sub-interface of statement
		int bookid = 0;
		try {
			statement = connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS);
			statement.setString(1, book.getTitle());          //setting value
			statement.setString(2, book.getAuthor());
			statement.setString(3, book.getCategory());
			statement.setDouble(4, book.getPrice());
			statement.executeUpdate();
			// get auto generate key
			ResultSet rs = statement.getGeneratedKeys();    //AutoGenerateKey
			while (rs.next()) {
				bookid = rs.getInt(1);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		BookDAO.closeConnection();                         //close connection
		return bookid;                                //return Book Id
	}

	public void updateBook(int bookid, double price) {
		connection = BookDAO.openConnection();                 //Open Connection
		String updateQuery = "update book set price=? where bookid=?"; //update Query
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(updateQuery);
			statement.setDouble(1, price);
			statement.setInt(2, bookid);
			statement.execute();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		BookDAO.closeConnection();
	}

	public void deleteBook(int bookid) {
		connection = BookDAO.openConnection();
		String deleteQuery = "delete from book where bookid=?";     //Delete Query
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(deleteQuery);
			statement.setInt(1, bookid);
			statement.execute();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		BookDAO.closeConnection();                                 //Close connection
	}

	public List<Book> getByAuthor(String author) throws BookNotFoundException {
		connection = BookDAO.openConnection();
		List<Book> BookByAuthor = new ArrayList<Book>();          //List of BookByAuthor declaration
		String selectQuery = "select * from book where author=?";
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(selectQuery); //PreparedStatement execute parameterized Query 
			statement.setString(1, author);
			ResultSet rs = statement.executeQuery();             
			while (rs.next()) {
				Book book = new Book();
				book.setBookId(rs.getInt("bookid"));
				book.setAuthor(rs.getString("author"));
				book.setTitle(rs.getString("title"));
				book.setCategory(rs.getString("category"));
				book.setPrice(rs.getDouble("price"));
				BookByAuthor.add(book);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		BookDAO.closeConnection();
		return BookByAuthor;                                //returning Book By Author
	}

	public List<Book> getBookByCategory(String category) throws BookNotFoundException {
		connection = BookDAO.openConnection();
		List<Book> BookByCategory = new ArrayList<Book>();
		String selectQuery = "select * from book where category=?";   //Query For selecting books By category
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(selectQuery);
			statement.setString(1, category);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				Book book = new Book();
				book.setBookId(rs.getInt("bookid"));
				book.setAuthor(rs.getString("author"));
				book.setTitle(rs.getString("title"));
				book.setCategory(rs.getString("category"));
				book.setPrice(rs.getDouble("price"));
				BookByCategory.add(book);
			}
		} catch (SQLException e) {

			e.printStackTrace();
			// throw e;
		}
		BookDAO.closeConnection();
		return BookByCategory;                       //Returning Book By Category
	}

	public List<Book> getByLessPrice(double price) throws BookNotFoundException {
		connection = BookDAO.openConnection();
		List<Book> BookByPrice = new ArrayList<Book>();
		String selectQuery = "select * from book where price<=?";   //Query For book By <=Price
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(selectQuery);
			statement.setDouble(1, price);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				Book book = new Book();
				book.setBookId(rs.getInt("bookid"));
				book.setAuthor(rs.getString("author"));
				book.setTitle(rs.getString("title"));
				book.setCategory(rs.getString("category"));
				book.setPrice(rs.getDouble("price"));
				BookByPrice.add(book);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		BookDAO.closeConnection();
		return BookByPrice;                             //returning book By price
	}

	public Book getById(int bookid) {
		connection = BookDAO.openConnection();      //open connection
		Book book = null;                          //Declare book as null
		String selectQuery = "select * from book where bookid=?"; //Query for selecting book By id
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(selectQuery);
			statement.setDouble(1, bookid); 
			ResultSet rs = statement.executeQuery();    //Execute the query Statement
			while (rs.next()) {
				book = new Book();
				book.setBookId(rs.getInt("bookid"));
				book.setAuthor(rs.getString("author"));
				book.setTitle(rs.getString("title"));
				book.setCategory(rs.getString("category"));
				book.setPrice(rs.getDouble("price"));
			}
		} catch (SQLException e) {

			e.printStackTrace();               //handling Exceptions
		}
		BookDAO.closeConnection();            //close connection
		
		return book;                          //return Book object
	}

}
