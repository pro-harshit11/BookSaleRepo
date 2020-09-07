package com.BookSale.model;

import java.time.LocalDate;


public class Book {

	private Integer bookId;
	private String bookName;
	private LocalDate bookYear;
	private Integer bookPrice;
	private Customer customer;
	private Branch branch;
	private Semester semester;
	
	public Branch getBranch() {
		return branch;
	}
	public void setBranch(Branch branch) {
		this.branch = branch;
	}
	public Semester getSemester() {
		return semester;
	}
	public void setSemester(Semester semester) {
		this.semester = semester;
	}
	public Integer getBookId() {
		return bookId;
	}
	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public LocalDate getBookYear() {
		return bookYear;
	}
	public void setBookYear(LocalDate bookYear) {
		this.bookYear = bookYear;
	}
	public Integer getBookPrice() {
		return bookPrice;
	}
	public void setBookPrice(Integer bookPrice) {
		this.bookPrice = bookPrice;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	
}
