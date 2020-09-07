package com.BookSale.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BookSale.dao.BookDAO;
import com.BookSale.model.Book;
import com.BookSale.model.Customer;
@Service(value="bookService")
@Transactional
public class BookServiceImpl implements BookSERVICE{
	@Autowired
	private BookDAO bookDao;

	@Override
	public Integer addBook(Book book, Integer customerId) throws Exception {
		Integer x=bookDao.addBook(book, customerId);
		if(x==-1){
			throw new Exception("Service.CUSTOMER_UNAVAILABLE");
		}
		return x;
	}

	@Override
	public List<Book> getBook() throws Exception {
		List<Book> b=	bookDao.getBook();
		if(b.isEmpty()){
			throw new Exception("Service.NO_BOOK_FOUND");
		}
		return b;
	}

	@Override
	public Integer deleteBook(Integer bookId) throws Exception {
		return bookDao.deleteBook(bookId);
	}

	@Override
	public Integer addUser(Customer customer) throws Exception {
		Customer x=bookDao.getUser(customer.getCustomerId());
		if(x!=null) {
			throw new Exception("Service.UserID_Already_Exists");
		}
		return bookDao.addUser(customer);
	}

	@Override
	public Customer getUser(Integer customerid, String password) throws Exception {
		Customer cus=bookDao.getUser(customerid);
		
		if(cus==null) {
			throw new Exception("Service.CUSTOMER_UNAVAILABLE");}
		if(!cus.getPassword().equals(password)) {throw new Exception("Service.PASSWORD_INCORRECT");}
		
		return cus;
		
	}

}
