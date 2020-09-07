package com.BookSale.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.BookSale.model.Book;
import com.BookSale.model.Customer;
import com.BookSale.service.BookSERVICE;


@CrossOrigin
@RestController
@RequestMapping(value= "/book")
public class BookAPI {
	@Autowired
	private BookSERVICE bookService;
	
	@Autowired
	public Environment environment;
	
	@GetMapping(value= "/books")
	public ResponseEntity<List<Book>> getBook() throws Exception{
		ResponseEntity<List<Book>> response=null;
		try{
		List<Book> b=bookService.getBook();
		response = new ResponseEntity<List<Book>>(b, HttpStatus.OK);	
	}
		catch(Exception e){
			String s=environment.getProperty(e.getMessage());
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,s,e);
	}
		return response;
		
}
	
	
	@PostMapping(value= "/getUser")
	public ResponseEntity<Customer> getUser(@RequestBody Customer cus) throws Exception{
		ResponseEntity<Customer> response=null;
		try{
		Customer cust=bookService.getUser(cus.getCustomerId(), cus.getPassword());
		
		
		
		
		response = new ResponseEntity<Customer>(cust, HttpStatus.CREATED);
		return response;
	}
		catch(Exception e){
			String s=environment.getProperty(e.getMessage());
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,s,e);
	}
		
		
}
	
	
	
	@PostMapping(value= "/book/{customerId}")
	public ResponseEntity<String> addBook(@RequestBody Book book,@PathVariable Integer customerId) throws Exception{
		ResponseEntity<String> response=null;
		try{
		Integer x=	bookService.addBook(book, customerId);
		String successMessage=environment.getProperty("API.BOOK_ADDED_SUCCESS")+":"+x;
	
		response = new ResponseEntity<String>(successMessage, HttpStatus.CREATED);
		}
		catch(Exception e){
			String s=environment.getProperty(e.getMessage());
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,s,e);
		}
		return response;
	}
	
	@PostMapping(value="/customers")
	public ResponseEntity<String> addUser(@RequestBody Customer customer) throws Exception{
		ResponseEntity<String> response=null;
		try{
			Integer x=bookService.addUser(customer);
			String successMessage=environment.getProperty("API.CUSTOMER_ADDED_SUCCESS");
			successMessage+=x;
			response=new ResponseEntity<String>(successMessage,HttpStatus.CREATED);	
		}
		catch(Exception e){
			String s=environment.getProperty(e.getMessage());
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,s,e);
		}
		return response;
		
	}
	@DeleteMapping(value="/book/{bookId}")
	public ResponseEntity<String> deleteBook(@PathVariable Integer bookId) throws Exception{
		ResponseEntity<String> response=null;
		try{
			Integer x=	bookService.deleteBook(bookId);
			String successMessage=environment.getProperty("API.BOOK_DELETED");
			successMessage+=x;
			response=new ResponseEntity<String>(successMessage,HttpStatus.OK);	
		}
		catch(Exception e){
			String s=environment.getProperty(e.getMessage());
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,s,e);
	}
		return response;
	}
	
	
}
