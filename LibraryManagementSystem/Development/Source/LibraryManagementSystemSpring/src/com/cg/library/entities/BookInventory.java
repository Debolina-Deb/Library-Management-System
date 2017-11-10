package com.cg.library.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "booksInventory")
@NamedQueries(@NamedQuery(name = "getAllBooks", query = "SELECT bookInventory FROM BookInventory bookInventory"))
public class BookInventory {
	
	@Id
	@Column(name="book_id")
	@NotNull(message="Book ID is required")
	@Pattern(regexp="[0-9]{4}",message="Book Id maximum length can be of 4 characters")
	private String bookId;
	@Column(name="book_name")
	@NotNull(message="Book Name is required")
	@Size(max=10,message="Maximum 20 characters required")
	private String bookName;
	@Column(name="author")
	@NotNull(message="Book Author Name is required")
	@Pattern(regexp="[a-zA-Z]{10}",message="Book Author name maximum length can be of 10 characters")
	private String author;
	@Column(name="publisher")
	@NotNull(message="Book Publisher is required")
	@Pattern(regexp="[a-zA-Z]{10}",message="Book Publisher maximum length can be of 4 characters")
	private String publisher;
	@Column(name="year_of_publication")
	private String yearOfPublication;
	@Column(name="no_Of_Book")
	@NotNull(message="Number of Books are required")
	@Size(max=5,message="Maximum 5 Books can be issued")
	private Integer noOfBooks;

	

	public String getBookId() {
		return bookId;
	}



	public void setBookId(String bookId) {
		this.bookId = bookId;
	}



	public String getBookName() {
		return bookName;
	}



	public void setBookName(String bookName) {
		this.bookName = bookName;
	}



	public String getAuthor() {
		return author;
	}



	public void setAuthor(String author) {
		this.author = author;
	}



	public String getPublisher() {
		return publisher;
	}



	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}



	public String getYearOfPublication() {
		return yearOfPublication;
	}



	public void setYearOfPublication(String yearOfPublication) {
		this.yearOfPublication = yearOfPublication;
	}



	public Integer getNoOfBooks() {
		return noOfBooks;
	}



	public void setNoOfBooks(Integer noOfBooks) {
		this.noOfBooks = noOfBooks;
	}



	@Override
	public String toString() {
		return "Book Id : " + bookId + ", Book Name : " + bookName
				+ ", Author1 : " + author
				+ ", Publisher : " + publisher + ", Year of Publication : "
				+ yearOfPublication + ", No of Books : " + noOfBooks;
	}

}
	
	
	


