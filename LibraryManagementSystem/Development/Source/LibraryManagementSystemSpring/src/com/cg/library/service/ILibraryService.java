package com.cg.library.service;

import java.util.List;

import com.cg.library.entities.BookInventory;
import com.cg.library.entities.BookRegistration;
import com.cg.library.entities.Users;
import com.cg.library.exception.LibraryException;

public interface ILibraryService {

	public abstract  BookInventory getBookById(String id) throws LibraryException;

	public abstract Users getUserDetails() throws LibraryException;

	public abstract BookInventory deleteBookById(String bookIdDelete) throws LibraryException;
	
	public abstract BookInventory insertBook(BookInventory book) throws LibraryException;
	
	public abstract List<BookInventory> getAllBooks() throws LibraryException;
	
	public abstract BookRegistration requestBook(BookRegistration bookRequest) throws LibraryException;
	
	public abstract int validateUser(String userName, String password) throws LibraryException;

	public abstract int returnBook(int inpRegId) throws LibraryException;
	
	public abstract void issueBook(int registrationId) throws LibraryException;
	
	public abstract List<BookRegistration> getAllRequest() throws LibraryException;
	
	public abstract Users addUser(Users user) throws LibraryException;
}