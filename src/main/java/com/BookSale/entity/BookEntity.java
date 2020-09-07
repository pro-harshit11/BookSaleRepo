package com.BookSale.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.BookSale.model.Branch;
import com.BookSale.model.Semester;



@Entity
@Table(name="Book")
public class BookEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer bookId;
	@Column(name="name")
	private String bookName;
	private LocalDate bookYear;
	@Column(name="price")
	private Integer bookPrice;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="customer_id")
	private CustomerEntity customer;
	
	@Enumerated(EnumType.STRING)
	private Branch branch;
	@Enumerated(EnumType.STRING)
	private Semester semester;
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
	public CustomerEntity getCustomer() {
		return customer;
	}
	public void setCustomer(CustomerEntity customer) {
		this.customer = customer;
	}
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
	
	
	

}
