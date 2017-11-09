package com.cg.library.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.library.dao.ILibraryDao;
import com.cg.library.entities.BookInventory;
import com.cg.library.entities.BookRegistration;
import com.cg.library.entities.Users;
import com.cg.library.exception.LibraryException;

@Service
public class LibraryServiceImpl implements ILibraryService {

	@Autowired
	private ILibraryDao dao;

	@Override
	public BookInventory getBookById(String id) throws LibraryException {
		return dao.getBookById(id);
	}
/*
	@Override
	public Long getBookCount() {
		return dao.getBookCount();
	}
*/
	@Override
	public List<BookInventory> getAllBooks() throws LibraryException {
		return dao.getAllBooks();
	}
	
	@Override
	public int validateUser(String userName, String password) throws LibraryException {
		return dao.validateUser(userName, password);
	}

	@Override
	public BookInventory insertBook(BookInventory book) throws LibraryException {
		return dao.insertBook(book);
	}

	@Override
	public BookInventory deleteBookById(String bookId) throws LibraryException {
		return dao.deleteBookById(bookId);
	}

	@Override
	public Users getUserDetails() throws LibraryException {
		return dao.getUserDetails();
	}

	@Override
	public BookRegistration requestBook(BookRegistration bookRequest) throws LibraryException {
		if(dao.getBookById(bookRequest.getBookId()) == null){
			return null;
		}else if(dao.getCountOfBooks(bookRequest.getBookId()) == 0){
			return null;
		}
		return dao.requestBook(bookRequest);
	}
	@Override
	public int returnBook(int inpRegId) throws LibraryException
	{
		return dao.returnBook(inpRegId);
	}

	@Override
	public void issueBook(int registrationId) throws LibraryException {
		dao.issueBook(registrationId);
	}

	@Override
	public List<BookRegistration> getAllRequest() throws LibraryException {
		return dao.getAllRequest();
	}
	@Override
	public Users addUser(Users user) throws LibraryException {
		
		return dao.addUser(user);
	}
}
