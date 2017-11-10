package com.cg.library.entities;


import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;


import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="booksRegistration")
@NamedQueries(@NamedQuery(name = "getAllRequests", query = "SELECT request FROM BookRegistration request"))
public class BookRegistration {

	@Id
	@Column(name="registration_id")
	@SequenceGenerator(name="reg_id_seq", initialValue = 1000)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="reg_id_seq")
	private int registrationId;
	@Column(name="book_id")
	private String bookId;
	@Column(name="user_id")
	private int userId;
	@Column(name="registration_date")
	private Date registrationDate;
	
	public int getRegistrationId() {
		return registrationId;
	}
	
	public void setRegistrationId(int registrationId) {
		this.registrationId = registrationId;
	}
	
	public String getBookId() {
		return bookId;
	}
	
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	
	public int getUserId() {
		return userId;
	}
	
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public Date getRegistrationDate() {
		return registrationDate;
	}
	
	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}

	@Override
	public String toString() {
		return "Registration Id : " + registrationId
				+ ", Book Id : " + bookId + ", User ID : " + userId
				+ ", Registration Date : " + registrationDate;
	}
	
	
	
	
}
