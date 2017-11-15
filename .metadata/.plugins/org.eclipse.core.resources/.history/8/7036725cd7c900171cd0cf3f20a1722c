package com.cg.library.util;
/************************************************************************************
 * File Name: QueryMapper 
 * Package Name: com.cg.lms.util
 * Description: Queries which are used in Data Access Object to interact with Database
 * Version: 1.0 Restrictions: N/A
 * @author   
 * Date: 14/11/2017
 ***********************************************************************************/
public interface QueryMapper {
	String validateUser = "SELECT u FROM User u WHERE u.userName=:userName AND u.password=:password";
	String returnBook = "SELECT t FROM BookTransaction t WHERE t.registrationId=";
	String requestByStatus = "SELECT t FROM BookRegistration t WHERE t.status=:status";
	String bookByAuthor = "SELECT l FROM BookInventory l WHERE lower(l.author) LIKE :authorName";
	String bookByName = "SELECT l FROM BookInventory l WHERE lower(l.bookName) LIKE :bookName";// '%bookName%'
	String getAllBooks = "getAllBooks";
	String getAllRequests = "getAllRequests";
}
