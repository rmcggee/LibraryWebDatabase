package model;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;

import javax.persistence.ManyToOne;
import javax.persistence.Table;

import controller.LocalDateAttributeConverter;
	@Entity
	@Table(name = "customer")
public class Customer {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "CUSTOMER_ID")
	private int id;
	@Column(name = "CUSTOMER_NAME")
	private String name;
	@Column(name = "CHECKOUT_DATE")
	@Convert(converter = LocalDateAttributeConverter.class)
	private LocalDate chekoutDate;
	@ManyToOne (cascade=CascadeType.ALL)
	@JoinColumns({
	@JoinColumn(name="BOOK_ID", referencedColumnName = "BOOK_ID"),@JoinColumn(name="BOOK_NAME",referencedColumnName="TITLE")
	})
	private Book book;
	
public Customer() {
	
}
public Customer(int id, String name,LocalDate checkoutDate, Book book) {
	this.id = id;
	this.name = name;
	this.chekoutDate = checkoutDate;
	this.book = book;
}
public Customer( String name, LocalDate checkoutDate, Book book) {
	this.name = name;
	this.chekoutDate = checkoutDate;
	this.book = book;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}

public LocalDate getCheckoutDate() {
	return chekoutDate;
}
public void setCheckoutDate(LocalDate checkoutDate) {
	this.chekoutDate = checkoutDate;
}
public Book getBook() {
	return book;
}
public void setBook(Book book) {
	this.book = book;
}
	
}

	
