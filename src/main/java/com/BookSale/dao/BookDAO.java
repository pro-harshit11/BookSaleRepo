package com.BookSale.dao;

import java.util.List;

import com.BookSale.model.Book;
import com.BookSale.model.Customer;


public interface BookDAO {

	public Integer addBook(Book book,Integer customerId) throws Exception;
	public List<Book> getBook() throws Exception;
	public Integer deleteBook(Integer bookId) throws Exception;
	public Integer addUser(Customer customer) throws Exception;
	public Customer getUser(Integer customerid) throws Exception;
}

