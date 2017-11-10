package com.cg.library.dao;

import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cg.library.entities.BookInventory;
import com.cg.library.entities.BookRegistration;
import com.cg.library.entities.BookTransaction;
import com.cg.library.entities.Users;

/**
 * Extraction of data from database takes place in this layer
 * 
 * @author parpatid
 */
@Repository
@Transactional
public class LibraryDaoImpl implements ILibraryDao {

	/**
	 * Used to generate logger
	 */
	private static Logger logger = Logger
			.getLogger(com.cg.library.dao.LibraryDaoImpl.class);

	static public Users user = new Users();

	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Method used to get Book by bookId
	 * 
	 * @param id
	 */
	@Override
	public BookInventory getBookById(String id) {
		BookInventory book = entityManager.find(BookInventory.class, id);
		return book;
	}

	/**
	 * Method used to get all books
	 */
	@Override
	public List<BookInventory> getAllBooks() {
		Query query = entityManager.createNamedQuery("getAllBooks");
		@SuppressWarnings("unchecked")
		List<BookInventory> bookList = query.getResultList();
		return bookList;
	}

	/**
	 * Method to get all requests
	 */
	@Override
	public List<BookRegistration> getAllRequest() {
		Query query = entityManager.createNamedQuery("getAllRequests");
		@SuppressWarnings("unchecked")
		List<BookRegistration> requestList = query.getResultList();
		return requestList;
	}

	/**
	 * Method to get count of books in inventory
	 * 
	 * @param bookId
	 */
	@Override
	public int getCountOfBooks(String bookId) throws Exception {
		TypedQuery<BookInventory> query1 = entityManager.createQuery(
				QueryMapper.getCountOfBooks + bookId, BookInventory.class);
		BookInventory booksInventory = query1.getSingleResult();
		return booksInventory.getNoOfBooks();
	}

	/**
	 * Method used to validate User
	 * 
	 * @param userName
	 * @param password
	 */
	@Override
	public Users validateUser(String userName, String password)
			throws Exception {
		TypedQuery<Users> query = entityManager.createQuery(
				QueryMapper.validateUser, Users.class);
		query.setParameter("puserName", userName);
		query.setParameter("ppassword", password);
		Users user1 = query.getSingleResult();
		user = user1;
		logger.info("Valid User with user ID : " + user1.getUserId());
		return user1;
	}

	/**
	 * Method used to insert Book into BookInventory
	 * 
	 * @param book
	 */
	@Override
	public BookInventory insertBook(BookInventory book) throws Exception {
		BookInventory book1 = this.getBookById(book.getBookId());
		if (book1 == null) {
			entityManager.persist(book);
			logger.info("Book Inserted with Book ID : " + book.getBookId());
		} else {
			this.updateBookQuan(book.getBookId(), book.getNoOfBooks());
		}
		return book;
	}

	/**
	 * Method used to get user details
	 * 
	 * @return user
	 */
	public Users getUserDetails() {
		return user;
	}

	/**
	 * Method used to validate registration id
	 * 
	 * @param inpRegId
	 */
	@Override
	public BookRegistration validRegId(int inpRegId) throws Exception {
		BookRegistration reg = entityManager.find(BookRegistration.class,
				inpRegId);
		logger.info("Valid Registration ID");
		return reg;
	}

	/**
	 * Method used to delete book by Id
	 * 
	 * @param bookId
	 */
	@Override
	public BookInventory deleteBookById(String bookId) throws Exception {
		BookInventory book = null;
		book = entityManager.find(BookInventory.class, bookId);
		entityManager.remove(book);
		logger.info("Book with Id: " + bookId + " deleted successfully");
		return book;
	}

	/**
	 * Method used to update quantity of book in BookInventory
	 * 
	 * @param bookId
	 * @param updateBy
	 */
	@Override
	public BookInventory updateBookQuan(String bookId, int updateBy)
			throws Exception {
		BookInventory inv = this.getBookById(bookId);
		inv.setNoOfBooks(inv.getNoOfBooks() + updateBy);
		entityManager.merge(inv);
		entityManager.flush();
		logger.info("Book with Id: " + inv.getBookId() + " updated successfully");
		return inv;
	}

	/**
	 * Method used to issue book with regId
	 * 
	 * @param registrationId
	 */
	@Override
	public void issueBook(int registrationId) throws Exception {
		// String qStr =
		// "SELECT t FROM BookRegistration t WHERE t.registrationId="+registrationId;
		TypedQuery<BookRegistration> query = entityManager.createQuery(
				QueryMapper.issueBook + registrationId, BookRegistration.class);
		BookRegistration registration = query.getSingleResult();
		BookTransaction bookTransaction = new BookTransaction();
		bookTransaction.setIssueDate(Date.valueOf(LocalDate.now()));
		bookTransaction.setRegistrationId(registrationId);
		// bookTransaction.setReturnDate(null);

		entityManager.persist(bookTransaction);

		// qStr =
		// "SELECT t FROM BookInventory t WHERE t.bookId="+registration.getBookId();
		TypedQuery<BookInventory> query1 = entityManager.createQuery(
				QueryMapper.updateIssueBook + registration.getBookId(),
				BookInventory.class);
		BookInventory booksInventory = query1.getSingleResult();
		booksInventory.setNoOfBooks(booksInventory.getNoOfBooks() - 1);

		entityManager.merge(booksInventory);

		logger.info("Book issued with registration ID: " + registrationId);
	}

	/**
	 * Method used to return book
	 * 
	 * @param inpRegId
	 */
	@Override
	public int returnBook(int inpRegId) throws Exception {
		int fine = -1;
		BookTransaction tran;
		TypedQuery<BookTransaction> query = entityManager.createQuery(
				QueryMapper.returnBook + inpRegId, BookTransaction.class);
		tran = query.getSingleResult();
		fine = 0;
		BookRegistration reg = this.validRegId(inpRegId);
		LocalDate issue = tran.getIssueDate().toLocalDate();
		LocalDate today = LocalDate.now();
		LocalDate expReturn = issue.plusDays(15);
		int chk = Period.between(expReturn, today).getDays();
		if (chk > 0)
			fine = chk * 10; // fine is 10rs per day
		tran.setReturnDate(java.sql.Date.valueOf(today));
		tran.setFine(fine);
		entityManager.merge(tran);
		this.updateBookQuan(reg.getBookId(), 1);
		logger.info("Book returned with registration ID: " + inpRegId);
		return fine;
	}

	/**
	 * Method used to request book
	 * 
	 * @param bookRequest
	 */
	@Override
	public BookRegistration requestBook(BookRegistration bookRequest)
			throws Exception {
		entityManager.persist(bookRequest);
		logger.info("Book requested for user ID" + bookRequest.getUserId());
		return bookRequest;
	}

	/**
	 * Method used to add user to Users table
	 * 
	 * @param user
	 */
	@Override
	public Users addUser(Users user) throws Exception {
		entityManager.persist(user);
		return user;
	}

	/**
	 * Method to get request by status
	 * 
	 * @throws Exception
	 */
	@Override
	public List<BookRegistration> getRequestByStatus(String status)
			throws Exception {
		TypedQuery<BookRegistration> query1 = entityManager.createQuery(
				QueryMapper.reqByStatus, BookRegistration.class);
		query1.setParameter("pstatus", status);
		List<BookRegistration> requestList = query1.getResultList();
		return requestList;
	}

	/**
	 * Method used to search book by author name
	 * 
	 * @param author
	 * @return books
	 */
	@Override
	public List<BookInventory> searchBookByAuthor(String author) {
		String qstr = "SELECT l FROM BookInventory l WHERE l.author='" + author
				+ "'";
		TypedQuery<BookInventory> query = entityManager.createQuery(qstr,
				BookInventory.class);
		List<BookInventory> books = query.getResultList();
		return books;

	}

	/**
	 * Method used to search book by name
	 * 
	 * @param bookName
	 * @return books
	 * @throws Exception
	 */
	@Override
	public List<BookInventory> searchBookByName(String bookName)
			throws Exception {
		String qstr = "SELECT l FROM BookInventory l WHERE l.bookName LIKE :bookName";// '%bookName%'
		TypedQuery<BookInventory> query = entityManager.createQuery(qstr,
				BookInventory.class);
		query.setParameter("bookName", bookName);
		List<BookInventory> books = query.getResultList();
		return books;

	}

}
