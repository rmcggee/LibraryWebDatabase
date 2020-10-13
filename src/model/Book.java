package model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "book")
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "BOOK_ID")
	private int bookId;
	
	@Column(name = "TITLE")
	private String title;
	
	@Column(name = "AUTHOR")
	private String author;
	
	@Column(name = "CALL_NBR_TXT")
	private String callNbrText;
	
	@Column(name = "PURCHASED_DATE")
	private LocalDate purchasedDate;
	
	// no argument constructor
	public Book() {
		super();
	}
	
	// constructor with fields
	public Book(String title, String author, String callNbrText) {
		super();
		this.title = title;
		this.author = author;
		this.callNbrText = callNbrText;
		this.purchasedDate = LocalDate.now();
	}
	
	// getters and setters
	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getCallNbrText() {
		return callNbrText;
	}

	public void setCallNbrText(String callNbrText) {
		this.callNbrText = callNbrText;
	}

	public LocalDate getPurchasedDate() {
		return purchasedDate;
	}

	public void setPurchasedDate(LocalDate purchasedDate) {
		this.purchasedDate = purchasedDate;
	}

	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", title=" + title + ", author=" + author + ", callNbrText=" + callNbrText
				+ ", purchasedDate=" + purchasedDate + "]";
	}


	
	
	
	
	
}
