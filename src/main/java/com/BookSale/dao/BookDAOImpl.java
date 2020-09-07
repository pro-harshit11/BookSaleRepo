package com.BookSale.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.BookSale.entity.BookEntity;
import com.BookSale.entity.CustomerEntity;
import com.BookSale.model.Book;
import com.BookSale.model.Customer;
@Repository(value="bookDAO")
public class BookDAOImpl implements BookDAO {
	@PersistenceContext
	private EntityManager entityManager;


	@Override
	public Integer addBook(Book book, Integer customerId) throws Exception {
		BookEntity be=new BookEntity();
		be.setBookName(book.getBookName());
		be.setBookPrice(book.getBookPrice());
		be.setBookYear(book.getBookYear());
		be.setBranch(book.getBranch());
		be.setSemester(book.getSemester());
		
		CustomerEntity cEnt=entityManager.find(CustomerEntity.class, customerId);
		
		if(cEnt==null){
			return -1;
		}
		
		be.setCustomer(cEnt);
		entityManager.persist(be);
		return be.getBookId();
	}



	@Override
	public Integer deleteBook(Integer bookId) throws Exception {
		BookEntity be=entityManager.find(BookEntity.class, bookId);
		if(be.getCustomer()!=null){
			be.setCustomer(null);
		}
		entityManager.remove(be);
		return be.getBookId();
	}

	@Override
	public Integer addUser(Customer customer) throws Exception {
		
		
		CustomerEntity ce=new CustomerEntity();
		ce.setCollegeName(customer.getCollegeName());
		ce.setCustomerId(customer.getCustomerId());
		ce.setPassword(customer.getPassword());
		ce.setCustomerName(customer.getCustomerName());
		ce.setContactNumber(customer.getContactNumber());
		entityManager.persist(ce);
		return ce.getCustomerId();
	}



	@Override
	public List<Book> getBook() throws Exception {
		List<Book> bookList=new ArrayList<>();
		Query query= entityManager.createQuery("select b from BookEntity b");
		List<BookEntity> list1=query.getResultList();
		if(list1.isEmpty()){
			return bookList;
		}
		for (BookEntity b : list1) {
			Book book=new Book();
			book.setBookId(b.getBookId());
			book.setBookName(b.getBookName());
			book.setBookPrice(b.getBookPrice());
			book.setBookYear(b.getBookYear());
			book.setBranch(b.getBranch());
			book.setSemester(b.getSemester());
			
			CustomerEntity ce=b.getCustomer();
			Customer c=new Customer();
			c.setCollegeName(ce.getCollegeName());
			c.setCustomerId(ce.getCustomerId());
			c.setCustomerName(ce.getCustomerName());
			c.setPassword(ce.getPassword());
			c.setContactNumber(ce.getContactNumber());
			book.setCustomer(c);
			bookList.add(book);
		}
		return bookList;
		
	}



	@Override
	public Customer getUser(Integer customerid) throws Exception {
		// TODO Auto-generated method stub
		CustomerEntity ce=entityManager.find(CustomerEntity.class,customerid);
		if(ce==null) {
			return null;
		}
		Customer cus=new Customer();
		cus.setCustomerId(ce.getCustomerId());
		cus.setCustomerName(ce.getCustomerName());
		cus.setCollegeName(ce.getCollegeName());
		cus.setPassword(ce.getPassword());
		return cus;
		
	
	}


}
