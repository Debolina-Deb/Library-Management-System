package com.cg.lms.service;

import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.lms.dao.LibraryDao;
import com.cg.lms.entities.BookInventory;
import com.cg.lms.entities.BookRegistration;
import com.cg.lms.entities.BookTransaction;
import com.cg.lms.entities.User;
import com.cg.lms.util.Constants;
/************************************************************************************
 * File Name: LibraryServiceImpl 
 * Package Name: com.cg.lms.service
 * Description: Implementation of Service Layer Interface which interacts with Data 
 * access object layer
 *  with the Librarian and Student Controller
 * Version: 1.0 Restrictions: N/A
 * @author   
 * Date: 14/11/2017
 ***********************************************************************************/
@Service
public class LibraryServiceImpl implements LibraryService {
	@Autowired
	private LibraryDao dao;

	/**
	 * Gets book by Book Id
	 * 
	 * @param bookId
	 *            - Book Id used to find Book
	 * @return book - BookInventory object used to manipulate further
	 */
	@Override
	public BookInventory getBookById(String bookId)  {
		return dao.getBookById(bookId);
	}

	/**
	 * Gets all books in BookInventory
	 * 
	 * @return books - Books in Book Inventory
	 */
	@Override
	public List<BookInventory> getAllBooks() throws Exception {
		return dao.getAllBooks();
	}

	/**
	 * Validates User
	 * 
	 * Validation of User with the userName and password given as input from the
	 * User table
	 * 
	 * @param userName
	 * @param password
	 * @throws Exception
	 */
	@Override
	public int validateUser(String userName, String password) throws Exception {
		User user = dao.validateUser(userName, password);
		if (user.isLibrarian().equals("true")) {
			return 1;
		} else {
			return 0;
		}
	}

	/**
	 * Inserts Book into BookInventory
	 * 
	 * Takes book details from user and persist it into BookInventory
	 * 
	 * @param book
	 *            - BookInventory object contains Book Details
	 * @throws Exception
	 */
	@Override
	public BookInventory insertBook(BookInventory book) throws Exception {
		return dao.insertBook(book);
	}

	/**
	 * Deletes book by book Id
	 * 
	 * Takes book id from user and delete the book from BookInventory
	 * 
	 * @param bookId
	 *            - Id which will be used to delete Book
	 * @return
	 * @throws Exception
	 */
	@Override
	public BookInventory deleteBookById(String bookId) throws Exception {
		return dao.deleteBookById(bookId);
	}

	/**
	 * Gets user details
	 * 
	 * @return user - User object contains user details
	 * @throws Exception
	 */
	@Override
	public User getUserDetails() throws Exception {
		return dao.getUserDetails();
	}

	/**
	 * Requests book from librarian
	 * 
	 * Book requests details are persisted in Book Registration table
	 * 
	 * @param bookRequest
	 *            - Book Request details for book requested by Student
	 * @return
	 * @throws Exception
	 */
	@Override
	public BookRegistration requestBook(BookRegistration bookRequest)
			throws Exception {
		BookInventory bookInventory = dao.getBookById(bookRequest.getBookId());
		if (bookInventory == null || bookInventory.getNoOfBooks() == 0) {
			return null;
		}
		return dao.requestBook(bookRequest);
	}

	/**
	 * Retrieves transaction details after returning book
	 * 
	 * @param inputRegistrationId
	 *            - Registration id used to get transaction details
	 * @return
	 * @throws Exception
	 */
	@Override
	public int returnBook(int inputRegistrationId) throws Exception {
		int fine = -1;
		BookTransaction tran = dao.returnBookTransaction(inputRegistrationId);
		fine = 0;
		BookRegistration reg = dao.getBookRegistration(inputRegistrationId);
		LocalDate issue = tran.getIssueDate().toLocalDate();
		LocalDate today = LocalDate.now();
		LocalDate expReturn = issue.plusDays(15);
		int chk = Period.between(expReturn, today).getDays();
		if (chk > 0)
			fine = chk * 10;
		tran.setReturnDate(Date.valueOf(today));
		tran.setFine(fine);
		reg.setStatus("returned");
		dao.updateBookTransaction(tran);
		dao.updateBookQuantity(reg.getBookId(), 1);
		dao.updateBookRegistration(reg);
		return fine;
	}

	/**
	 * Inserts transaction details while book is issued
	 * 
	 * @param bookTransaction - BookTransaction object contains Transaction details 
	 * @throws Exception
	 */
	@Override
	public void issueBook(int registrationId) throws Exception {

		BookRegistration registration = dao.getBookRegistration(registrationId);
		registration.setStatus(Constants.issued);
		BookTransaction bookTransaction = new BookTransaction();
		bookTransaction.setIssueDate(Date.valueOf(LocalDate.now()));
		bookTransaction.setRegistrationId(registrationId);
		dao.issueBook(bookTransaction);
		dao.updateBookQuantity(registration.getBookId(), -1);
		dao.updateBookRegistration(registration);
	}

	/**
	 * Gets all requests in BookRegistration
	 * 
	 * @return requests - All requests from Book Registration
	 */
	@Override
	public List<BookRegistration> getAllRequests() throws Exception {
		return dao.getAllRequests();
	}

	/**
	 * Adds user to User table
	 * 
	 * User's data are persisted in User table
	 * 
	 * @param user
	 *            - User object to persist in database
	 * @return user - User object returned for further manipulation
	 * @throws Exception
	 */
	@Override
	public User addUser(User user) throws Exception {

		return dao.addUser(user);
	}

	/**
	 * Gets requests by status
	 * 
	 * Status given as input is the state of the transaction which can be
	 * pending or issued and w.r.t status the list of requests are retrieved
	 * 
	 * @param status
	 *            - State of transaction i.e. pending or issued
	 * @return requests - List of requests according to status
	 * @throws Exception
	 */
	@Override
	public List<BookRegistration> getRequestByStatus(String status)
			throws Exception {
		return dao.getRequestByStatus(status);
	}

	/**
	 * Search book by author name
	 * 
	 * Author name is taken as input and the given query matches the authorName
	 * with the author present in BookInventory table and returns all book with
	 * that keyword
	 * 
	 * @param authorName
	 *            - Author name used to compare with the table column author
	 * @return books - List of books with the given author name
	 * @throws Exception
	 */
	@Override
	public List<BookInventory> searchBookByAuthor(String authorName)
			throws Exception {
		return dao.searchBookByAuthor(authorName);

	}

	/**
	 * Search book by Book Name
	 * 
	 * Book Name is given as input and the query matched the given name with the
	 * book name from the BookInventory table from database
	 * 
	 * @param bookName
	 *            - name of book to be searched
	 * @return books - all books with the given keyword as bookName
	 * @throws Exception
	 */
	@Override
	public List<BookInventory> searchBookByName(String bookName)
			throws Exception {
		return dao.searchBookByName(bookName);
	}
}
