package com.cg.lms.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

import com.sun.istack.internal.NotNull;

@Entity
@Table(name = "booksInventory")
@NamedQueries(@NamedQuery(name = "getAllBooks", query = "SELECT bookInventory FROM BookInventory bookInventory"))
public class BookInventory implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1629892883246063273L;
	@Id
	@NotEmpty
	@Column(name = "book_id")
	private String bookId;

	@NotEmpty
	@Column(name = "book_name")
	private String bookName;

	@NotEmpty
	@Column(name = "author")
	private String author;

	@NotEmpty
	@Column(name = "publisher")
	private String publisher;

	@NotEmpty
	@Pattern(regexp="[0-9]{4}",message="digits only")
	@Column(name = "year_of_publication")
	private String yearOfPublication;

	@NotNull
	@Column(name = "no_Of_Book")
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
				+ ", Author : " + author + ", Publisher : " + publisher
				+ ", Year of Publication : " + yearOfPublication
				+ ", No of Books : " + noOfBooks;
	}

}
