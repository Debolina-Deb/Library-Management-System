package com.cg.library.service;

import java.util.List;

import com.cg.library.entities.BookInventory;
import com.cg.library.entities.BookRegistration;
import com.cg.library.entities.User;

public interface LibraryService {
	
	BookInventory getBookById(String bookId) throws Exception;

	User getUserDetails() throws Exception;

	BookInventory deleteBookById(String bookId) throws Exception;

	BookInventory insertBook(BookInventory book) throws Exception;

	List<BookInventory> getAllBooks() throws Exception;

	BookRegistration requestBook(BookRegistration bookRequest) throws Exception;

	int validateUser(String userName, String password) throws Exception;

	int returnBook(int registrationId) throws Exception;

	void issueBook(int registrationId) throws Exception;

	List<BookRegistration> getAllRequests() throws Exception;

	User addUser(User user) throws Exception;

	List<BookRegistration> getRequestByStatus(String status) throws Exception;

	List<BookInventory> searchBookByAuthor(String authorName) throws Exception;

	List<BookInventory> searchBookByName(String bookName) throws Exception;
}
