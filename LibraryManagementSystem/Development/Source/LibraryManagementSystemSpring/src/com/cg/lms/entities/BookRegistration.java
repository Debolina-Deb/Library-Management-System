package com.cg.lms.entities;


import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="booksRegistration")
@NamedQueries(@NamedQuery(name = "getAllRequests", query = "SELECT request FROM BookRegistration request"))
public class BookRegistration {

	@Id
	@Column(name="registration_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int registrationId;
	@Column(name="book_id")
	private String bookId;
	@Column(name="user_id")
	private int userId;
	@Column(name="registration_date")
	private Date registrationDate;
	@Column(name="status")
	private String status = "pending";
	
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "BookRegistration [registrationId=" + registrationId
				+ ", bookId=" + bookId + ", userId=" + userId
				+ ", registrationDate=" + registrationDate + ", status="
				+ status + "]";
	}

	
	
	
	
	
}
