package com.cg.library.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.library.dao.ILibraryDao;
import com.cg.library.entities.BookInventory;
import com.cg.library.entities.BookRegistration;
import com.cg.library.entities.Users;

@Service
public class LibraryServiceImpl implements ILibraryService {

	@Autowired
	private ILibraryDao dao;

	@Override
	public BookInventory getBookById(String id) throws Exception {
		return dao.getBookById(id);
	}

	/*
	 * @Override public Long getBookCount() { return dao.getBookCount(); }
	 */
	
	@Override
	public List<BookInventory> getAllBooks() throws Exception {
		return dao.getAllBooks();
	}

	@Override
	public int validateUser(String userName, String password)
			throws Exception {
		Users user1 = dao.validateUser(userName, password);
		if (user1.isLibrarian().equals("true")) {
			return 1;
		} else {
			return 0;
		}
	}

	@Override
	public BookInventory insertBook(BookInventory book) throws Exception {
		return dao.insertBook(book);
	}

	@Override
	public BookInventory deleteBookById(String bookId) throws Exception {
		return dao.deleteBookById(bookId);
	}

	@Override
	public Users getUserDetails() throws Exception {
		return dao.getUserDetails();
	}

	@Override
	public BookRegistration requestBook(BookRegistration bookRequest)
			throws Exception {
		if (dao.getBookById(bookRequest.getBookId()) == null) {
			return null;
		} else if (dao.getCountOfBooks(bookRequest.getBookId()) == 0) {
			return null;
		}
		return dao.requestBook(bookRequest);
	}

	@Override
	public int returnBook(int inpRegId) throws Exception {
		return dao.returnBook(inpRegId);
	}

	@Override
	public void issueBook(int registrationId) throws Exception {
		dao.issueBook(registrationId);
	}

	@Override
	public List<BookRegistration> getAllRequest() throws Exception {
		return dao.getAllRequest();
	}

	@Override
	public Users addUser(Users user) throws Exception {

		return dao.addUser(user);
	}

	@Override
	public List<BookRegistration> getRequestByStatus(String status)
			throws Exception {
		return dao.getRequestByStatus(status);
	}

	@Override
	public List<BookInventory> searchBookByAuthor(String author)
			throws Exception {
		return dao.searchBookByAuthor(author);

	}

	@Override
	public List<BookInventory> searchBookByName(String bookName)
			throws Exception {
		return dao.searchBookByName(bookName);
	}
}
