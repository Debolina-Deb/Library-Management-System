package com.cg.library.entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "booksTransaction")
public class BookTransaction {
	@Id
	@Column(name="transaction_id")
	@SequenceGenerator(name="trn_id_seq", initialValue = 100)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="trn_id_seq")
	private int transactionId;
	@Column(name="registration_id")
	private int registrationId;
	@Column(name="issue_date")
	private Date issueDate;
	@Column(name="return_date")
	private Date returnDate;
	@Column(name="fine")
	private Integer fine;
	
	
	
	public Date getIssueDate() {
		return issueDate;
	}
	
	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}
	
	public Date getReturnDate() {
		return returnDate;
	}
	
	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}
	
	public int getFine() {
		return fine;
	}


	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	public int getRegistrationId() {
		return registrationId;
	}

	public void setRegistrationId(int registrationId) {
		this.registrationId = registrationId;
	}

	public void setFine(Integer fine) {
		this.fine = fine;
	}

	@Override
	public String toString() {
		return "BookTransaction [transactionId=" + transactionId
				+ ", registrationId=" + registrationId + ", issueDate="
				+ issueDate + ", returnDate=" + returnDate + ", fine=" + fine
				+ "]";
	}
	}
	
	


