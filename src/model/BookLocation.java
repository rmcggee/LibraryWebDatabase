package model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "book_location")
public class BookLocation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "LOCATION_ID")
	private int locationId;
	
	@Column(name = "SECTION_NM")
	private String sectionName;
	
	@Column(name = "SHELF_NM")
	private String shelfName;
	
	@Column(name = "CRTE_DATE")
	private LocalDate createDate;
	
	@OneToOne
	@JoinColumn(name = "BOOK_ID")

	private Book myBook;
	
	public BookLocation() {
		super();
	}
	
	public BookLocation(String sectionName, String shelfName, Book myBook) {
		super();
		this.sectionName = sectionName;
		this.shelfName = shelfName;
		this.createDate = LocalDate.now();
		this.myBook = myBook;
	}

	public int getLocationId() {
		return locationId;
	}

	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}

	public String getSectionName() {
		return sectionName;
	}

	public void setSectionName(String sectionName) {
		this.sectionName = sectionName;
	}

	public String getShelfName() {
		return shelfName;
	}

	public void setShelfName(String shelfName) {
		this.shelfName = shelfName;
	}

	public LocalDate getCreateDate() {
		return createDate;
	}

	public void setCreateDate(LocalDate createDate) {
		this.createDate = createDate;
	}

	public Book getMyBook() {
		return myBook;
	}

	public void setMyBook(Book myBook) {
		this.myBook = myBook;
	}

	@Override
	public String toString() {
		return "BookLocation [locationId=" + locationId + ", sectionName=" + sectionName + ", shelfName=" + shelfName
				+ ", createDate=" + createDate + ", myBook=" + myBook + "]";
	}
	
	
	
	
	
}
