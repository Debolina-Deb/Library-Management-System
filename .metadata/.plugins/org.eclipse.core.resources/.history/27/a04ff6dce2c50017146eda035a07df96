package com.cg.library.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "booksInventory")
@NamedQueries(@NamedQuery(name = "getAllBooks", query = "SELECT bookInventory FROM BookInventory bookInventory"))
public class BookInventory {
	
	@Id
	@Column(name="book_id")
	private String bookId;
	@Column(name="book_name")
	private String bookName;
	@Column(name="author")
	private String author;
	@Column(name="publisher")
	private String publisher;
	@Column(name="year_of_publication")
	private String yearOfPublication;
	@Column(name="no_Of_Book")
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
	
	
	


