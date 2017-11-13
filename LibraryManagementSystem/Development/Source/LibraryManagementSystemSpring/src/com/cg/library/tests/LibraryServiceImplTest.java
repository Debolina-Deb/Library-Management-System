package com.cg.library.tests;

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
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import com.cg.library.dao.ILibraryDao;
import com.cg.library.entities.BookInventory;
import com.cg.library.entities.BookRegistration;
import com.cg.library.entities.Users;
import com.cg.library.service.ILibraryService;
import com.cg.library.service.LibraryServiceImpl;


@RunWith(MockitoJUnitRunner.class)
public class LibraryServiceImplTest {

	@Mock
	private ILibraryDao libraryDao;
	
	@InjectMocks
	private ILibraryService libraryServiceImpl = new LibraryServiceImpl();
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testGetBookById() throws Exception {
		String bookId = "123";
		BookInventory bookInventory = new BookInventory();
		bookInventory.setBookId(bookId);
		stub(libraryDao.getBookById(bookId)).toReturn(bookInventory);
		
		assertEquals(bookInventory, libraryServiceImpl.getBookById(bookId));
		verify(libraryDao).getBookById(bookId);
	}

	@Test
	public void testGetAllBooks() throws Exception {
		List<BookInventory> bookInventories = new ArrayList<BookInventory>();
		BookInventory book1 = new BookInventory();
		BookInventory book2 = new BookInventory();
		BookInventory book3 = new BookInventory();
		book1.setBookId("123");
		book2.setBookId("1234");
		book3.setBookId("345");
		
		stub(libraryDao.getAllBooks()).toReturn(bookInventories);
		
		assertEquals(bookInventories, libraryServiceImpl.getAllBooks());
		verify(libraryDao).getAllBooks();
	}

	@Test
	public void testValidateUser() throws Exception {
		Users users = new Users();
		String userName = "username";
		String password = "password";
		users.setUserName(userName);
		users.setPassword(password);
		users.setLibrarian("true");
		
		stub(libraryDao.validateUser(userName, password)).toReturn(users);
		
		assertEquals(1, libraryServiceImpl.validateUser(userName, password));
		verify(libraryDao).validateUser(userName, password);
	}

	@Test
	public void testInsertBook() throws Exception {
		BookInventory bookInventory = new BookInventory();
		String bookId = "123";
		bookInventory.setBookId(bookId);
		
		stub(libraryDao.insertBook(bookInventory)).toReturn(bookInventory);
		
		assertEquals(bookInventory, libraryServiceImpl.insertBook(bookInventory));
		verify(libraryDao).insertBook(bookInventory);
	}

	@Test
	public void testDeleteBookById() throws Exception {
		BookInventory bookInventory = new BookInventory();
		String bookId = "123";
		bookInventory.setBookId(bookId);
		
		stub(libraryDao.deleteBookById(bookId)).toReturn(bookInventory);
		
		assertEquals(bookInventory, libraryServiceImpl.deleteBookById(bookId));
		verify(libraryDao).deleteBookById(bookId);
	}

	@Test
	public void testGetUserDetails() throws Exception {
		Users users = new Users();
		String userName = "username";
		String password = "password";
		users.setUserName(userName);
		users.setPassword(password);
		users.setLibrarian("true");
		
		stub(libraryDao.getUserDetails()).toReturn(users);
		
		assertEquals(users, libraryServiceImpl.getUserDetails());
		verify(libraryDao).getUserDetails();
	}

	@Test
	public void testRequestBook() throws Exception {
		BookRegistration bookRegistration = new BookRegistration();
		bookRegistration.setBookId("123");
		bookRegistration.setRegistrationDate(Date.valueOf(LocalDate.now()));
		bookRegistration.setRegistrationId(12);
		bookRegistration.setStatus("pending");
		bookRegistration.setUserId(1234);
		BookInventory bookInventory = new BookInventory();
		bookInventory.setBookId("123");
		stub(libraryDao.getBookById(bookRegistration.getBookId())).toReturn(bookInventory);
		stub(libraryDao.requestBook(bookRegistration)).toReturn(bookRegistration);
		
		assertEquals(bookRegistration, libraryServiceImpl.requestBook(bookRegistration));
		verify(libraryDao).requestBook(bookRegistration);
	}
/*
	@Test
	public void testReturnBook() {
		fail("Not yet implemented");
	}

	@Test
	public void testIssueBook() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetAllRequest() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddUser() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetRequestByStatus() {
		fail("Not yet implemented");
	}

	@Test
	public void testSearchBookByAuthor() {
		fail("Not yet implemented");
	}

	@Test
	public void testSearchBookByName() {
		fail("Not yet implemented");
	}
*/
}
