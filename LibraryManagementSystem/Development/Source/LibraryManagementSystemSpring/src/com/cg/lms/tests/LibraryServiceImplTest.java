package com.cg.lms.tests;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.stub;
import static org.mockito.Mockito.verify;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import com.cg.lms.dao.LibraryDao;
import com.cg.lms.entities.BookInventory;
import com.cg.lms.entities.BookRegistration;
import com.cg.lms.entities.BookTransaction;
import com.cg.lms.entities.User;
import com.cg.lms.service.LibraryService;
import com.cg.lms.service.LibraryServiceImpl;
import com.cg.lms.util.Constants;
/**
 * Test class for Service Layer
 * 
 * @author 
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class LibraryServiceImplTest {

	@Mock
	private LibraryDao libraryDao;
	@InjectMocks
	private LibraryService libraryServiceImpl = new LibraryServiceImpl();

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	/**
	 * Tests the getBookById method
	 * 
	 * getBookById method returns the Book Inventory object after 
	 * searching in the BookInventory Table. 
	 * 
	 * @throws Exception
	 */
	@Test
	public void testGetBookById() throws Exception {
		String bookId = "123";
		BookInventory bookInventory = new BookInventory();

		bookInventory.setBookId(bookId);
		stub(libraryDao.getBookById(bookId)).toReturn(bookInventory);
		assertEquals(bookInventory, libraryServiceImpl.getBookById(bookId));
		verify(libraryDao).getBookById(bookId);
	}

	/**
	 * Tests the getAllBooks method
	 * 
	 * getAllBooks method returns list of books from BookInventory table 
	 * 
	 * @throws Exception
	 */
	@Test
	public void testGetAllBooks() throws Exception {
		List<BookInventory> bookInventories = this.getBookInventories();

		stub(libraryDao.getAllBooks()).toReturn(bookInventories);
		assertEquals(bookInventories, libraryServiceImpl.getAllBooks());
		verify(libraryDao).getAllBooks();
	}

	/**
	 * Tests validateUser method
	 * 
	 * validateUser method takes userName and password as input and checks 
	 * whether the user exists and is it librarian or student
	 * 
	 * @throws Exception
	 */
	@Test
	public void testValidateUser() throws Exception {
		User users = new User();
		String userName = "username";
		String password = "password";
		users.setUserName(userName);
		users.setPassword(password);
		users.setLibrarian("true");
		stub(libraryDao.validateUser(userName, password)).toReturn(users);
		assertEquals(1, libraryServiceImpl.validateUser(userName, password));
		verify(libraryDao).validateUser(userName, password);
	}

	/**
	 * Tests insertBook method 
	 * 
	 * insertBook method takes BookInventory object as input 
	 * and persist it in BookInventory table
	 * 
	 * @throws Exception
	 */
	@Test
	public void testInsertBook() throws Exception {
		BookInventory bookInventory = new BookInventory();
		String bookId = "123";
		bookInventory.setBookId(bookId);
		stub(libraryDao.insertBook(bookInventory)).toReturn(bookInventory);
		assertEquals(bookInventory,
				libraryServiceImpl.insertBook(bookInventory));
		verify(libraryDao).insertBook(bookInventory);
	}
	
	/**
	 * Tests deleteBookById method
	 * 
	 * deleteBookById method takes BookInventory object as input and 
	 * find the book from bookId in BookInventory table and remove it 
	 * if it exists
	 * 
	 * @throws Exception
	 */
	@Test
	public void testDeleteBookById() throws Exception {
		BookInventory bookInventory = new BookInventory();
		String bookId = "123";
		bookInventory.setBookId(bookId);
		stub(libraryDao.deleteBookById(bookId)).toReturn(bookInventory);
		assertEquals(bookInventory, libraryServiceImpl.deleteBookById(bookId));
		verify(libraryDao).deleteBookById(bookId);
	}

	/**
	 * Tests getUserDetails method 
	 * 
	 * @throws Exception
	 */
	@Test
	public void testGetUserDetails() throws Exception {
		User users = new User();
		String userName = "username";
		String password = "password";
		users.setUserName(userName);
		users.setPassword(password);
		users.setLibrarian("true");
		stub(libraryDao.getUserDetails()).toReturn(users);
		assertEquals(users, libraryServiceImpl.getUserDetails());
		verify(libraryDao).getUserDetails();
	}

	/**
	 * Tests requestBook method 
	 * 
	 * requestBook method takes BookRegistration object as input
	 * persist the request made by user 
	 * 
	 * @throws Exception
	 */
	@Test
	public void testRequestBook() throws Exception {
		BookRegistration bookRegistration = new BookRegistration();
		bookRegistration.setBookId("123");
		bookRegistration.setRegistrationDate(Date.valueOf(LocalDate.now()));
		bookRegistration.setRegistrationId(12);
		bookRegistration.setStatus(Constants.pending);
		bookRegistration.setUserId(1234);
		BookInventory bookInventory = new BookInventory();
		bookInventory.setBookId("123");
		bookInventory.setNoOfBooks(12);
		stub(libraryDao.getBookById(Mockito.anyString())).toReturn(
				bookInventory);
		stub(libraryDao.requestBook(bookRegistration)).toReturn(
				bookRegistration);
		assertEquals(bookRegistration,
				libraryServiceImpl.requestBook(bookRegistration));
		verify(libraryDao).requestBook(bookRegistration);
		verify(libraryDao).getBookById(Mockito.anyString());
	}

	/**
	 * Tests returnBook method 
	 * 
	 * returnBook method takes BookRegistration object as input and 
	 * insert the transaction for returning the book
	 * 
	 * @throws Exception
	 */
	@Test
	public void testReturnBook() throws Exception {
		BookTransaction bookTransaction = new BookTransaction();
		bookTransaction.setRegistrationId(1234);
		bookTransaction.setIssueDate(Date.valueOf(LocalDate.now()));
		BookRegistration bookRegistration = new BookRegistration();
		bookRegistration.setRegistrationId(1234);
		stub(libraryDao.returnBookTransaction(Mockito.anyInt())).toReturn(
				bookTransaction);
		stub(libraryDao.getBookRegistration(Mockito.anyInt())).toReturn(
				bookRegistration);
		assertEquals(0, libraryServiceImpl.returnBook(Mockito.anyInt()));
		verify(libraryDao).updateBookTransaction(bookTransaction);
		verify(libraryDao).updateBookQuantity(Mockito.anyString(),
				Mockito.anyInt());
		verify(libraryDao).updateBookRegistration(bookRegistration);
	}

	/**
	 * Tests issueBook method 
	 * 
	 * testBook method takes BookRegistration object and insert transaction 
	 * with the status issued in registration table
	 * 
	 * @throws Exception
	 */
	@Test
	public void testIssueBook() throws Exception {
		BookRegistration bookRegistration = new BookRegistration();
		bookRegistration.setRegistrationId(1234);
		stub(libraryDao.getBookRegistration(Mockito.anyInt())).toReturn(
				bookRegistration);
		BookTransaction bookTransaction = new BookTransaction();
		bookTransaction.setIssueDate(Date.valueOf(LocalDate.now()));
		bookTransaction.setRegistrationId(1234);
		libraryServiceImpl.issueBook(1234);
		verify(libraryDao, Mockito.times(1)).updateBookQuantity(
				Mockito.anyString(), Mockito.anyInt());
		verify(libraryDao, Mockito.times(1)).updateBookRegistration(
				bookRegistration);
	}

	/**
	 * Tests getAllRequests method
	 * 
	 * getAllRequests method retrieves all the request from BookRegistration 
	 * table
	 * 
	 * @throws Exception
	 */
	@Test
	public void testGetAllRequest() throws Exception {
		List<BookRegistration> bookRegistrations = new ArrayList<BookRegistration>();
		BookRegistration bookRegistration1 = new BookRegistration();
		BookRegistration bookRegistration2 = new BookRegistration();
		bookRegistration1.setRegistrationId(123);
		bookRegistration2.setRegistrationId(321);
		bookRegistrations.add(bookRegistration1);
		bookRegistrations.add(bookRegistration2);
		stub(libraryDao.getAllRequests()).toReturn(bookRegistrations);
		assertEquals(bookRegistrations, libraryServiceImpl.getAllRequests());
		verify(libraryDao).getAllRequests();
	}

	/**
	 * Tests addUser method 
	 * 
	 *  addUser method takes User details as input and persists it into
	 *  Users table
	 * 
	 * @throws Exception
	 */
	@Test
	public void testAddUser() throws Exception {
		User users = new User();
		String userName = "username";
		String password = "password";
		users.setUserName(userName);
		users.setPassword(password);
		users.setLibrarian("true");
		stub(libraryDao.addUser(users)).toReturn(users);
		assertEquals(users, libraryServiceImpl.addUser(users));
		verify(libraryDao).addUser(users);
	}

	/**
	 * Tests getRequestByStatus method
	 * 
	 * getRequestByStatus method takes transaction status i.e issued or pending 
	 * and according return the BookRegistration object
	 * 
	 * @throws Exception
	 */
	@Test
	public void testGetRequestByStatus() throws Exception {
		List<BookRegistration> bookRegistrations = new ArrayList<BookRegistration>();
		BookRegistration bookRegistration1 = new BookRegistration();
		BookRegistration bookRegistration2 = new BookRegistration();
		bookRegistration1.setRegistrationId(123);
		bookRegistration1.setStatus("issued");
		bookRegistration2.setRegistrationId(321);
		bookRegistration2.setStatus("issued");
		bookRegistrations.add(bookRegistration1);
		bookRegistrations.add(bookRegistration2);
		stub(libraryDao.getRequestByStatus(Mockito.anyString())).toReturn(
				bookRegistrations);
		assertEquals(bookRegistrations,
				libraryServiceImpl.getRequestByStatus(Mockito.anyString()));
		verify(libraryDao).getRequestByStatus(Mockito.anyString());
	}

	/**
	 * Tests searchBookByAuthor method 
	 * 
	 * searchBookByAuthor method takes authorName as input and search for 
	 * author name in BookInventory table and returns the BookList 
	 * 
	 * @throws Exception
	 */
	@Test
	public void testSearchBookByAuthor() throws Exception {
		List<BookInventory> bookInventories = this.getBookInventories();
		stub(libraryDao.searchBookByAuthor(Mockito.anyString())).toReturn(
				bookInventories);
		assertEquals(bookInventories,
				libraryServiceImpl.searchBookByAuthor(Mockito.anyString()));
		verify(libraryDao).searchBookByAuthor(Mockito.anyString());
	}

	/**
	 * Test searchBookByName method
	 * 
	 * searchBookByName method takes bookName as input and return the 
	 * Book list of books whose name include the given bookName
	 * 
	 * @throws Exception
	 */
	@Test
	public void testSearchBookByName() throws Exception {
		List<BookInventory> bookInventories = this.getBookInventories();
		stub(libraryDao.searchBookByName(Mockito.anyString())).toReturn(
				bookInventories);
		assertEquals(bookInventories,
				libraryServiceImpl.searchBookByName(Mockito.anyString()));
		verify(libraryDao).searchBookByName(Mockito.anyString());
	}

	/**
	 * Gets list of books from BookInventory
	 * 
	 * 
	 * 
	 * @return
	 */
	private List<BookInventory> getBookInventories() {
		List<BookInventory> bookInventories = new ArrayList<BookInventory>();
		BookInventory book1 = new BookInventory();
		BookInventory book2 = new BookInventory();
		BookInventory book3 = new BookInventory();
		book1.setBookId("123");
		book1.setAuthor("author");
		book1.setBookName("book1");
		book2.setBookId("1234");
		book2.setAuthor("author");
		book1.setBookName("book2");
		book3.setBookId("345");
		book3.setAuthor("author");
		book3.setBookName("book1");
		bookInventories.add(book1);
		bookInventories.add(book2);
		bookInventories.add(book3);
		return bookInventories;
	}
}
