package com.cg.library.dao;

public class QueryMapper {
	
	static final String getCountOfBooks = "SELECT t FROM BookInventory t WHERE t.bookId=";
	static final String validateUser = "SELECT u FROM Users u WHERE u.userName=:puserName AND u.password=:ppassword";
	static final String returnBook = "SELECT t FROM BookTransaction t WHERE t.registrationId=";
	static final String reqByStatus= "SELECT t FROM BookRegistration t WHERE t.status=:pstatus";
	static final String bookByAuthor = "SELECT l FROM BookInventory l WHERE lower(l.author) LIKE :author";
	static final String bookByName = "SELECT l FROM BookInventory l WHERE lower(l.bookName) LIKE :bookName";// '%bookName%'


}
