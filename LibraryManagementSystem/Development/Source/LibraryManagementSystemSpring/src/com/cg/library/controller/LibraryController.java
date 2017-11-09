package com.cg.library.controller;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cg.library.entities.BookInventory;
import com.cg.library.entities.BookRegistration;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cg.library.entities.Users;
import com.cg.library.exception.LibraryException;
import com.cg.library.service.ILibraryService;

@Controller
public class LibraryController {

	@Autowired
	ILibraryService service;

	/**
	 * Method used to display book
	 * 
	 * @param model
	 * @param userName
	 * @return
	 */
	@RequestMapping(value = "/display")
	public String displayBook(Model model,
			@RequestParam("userName") String userName) {
		try {
			List<BookInventory> allBook = service.getAllBooks();
			model.addAttribute("allBook", allBook);
			model.addAttribute("userName", userName);
		} catch (LibraryException le) {
			model.addAttribute("message", le.getMessage());
			return "Error";
		}
		return "DisplayBook";
	}

	/**
	 * Method used for deleting Book from Inventory
	 * 
	 * @param bookId
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/delete.htm")
	public String deleteBook(@RequestParam("bookId") String bookId, Model model) {
		try {
			BookInventory book = service.deleteBookById(bookId);
			model.addAttribute("message",
					"Book with book id:" + book.getBookId() + "deleted");
			model.addAttribute("userName", "parag");
		} catch (LibraryException e) {
			model.addAttribute("message", e.getMessage());
			return "Error";
		}
		return "LibrarianOperation";
	}
	
	/**
	 * Method used to check Whether Book existing
	 * 
	 * @param bookId
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/checkBook")
	public String addUpdate(@RequestParam("bookId") String bookId, Model model) {
		try {
			BookInventory book = service.getBookById(bookId);
			if (book == null) {
				model.addAttribute("book", new BookInventory());
				return "AddBook";
			} else {
				model.addAttribute("book", book);
				return "AddBook";
			}
		} catch (LibraryException e) {
			model.addAttribute("message", e.getMessage());
			return "Error";
		}

	}

	/**
	 * Method redirecting request to AddBook page
	 * 
	 * @return
	 */
	@RequestMapping(value = "addUpdate.htm")
	public String addUpdateBook() {
		// model.addAttribute("book",new BookInventory());
		return "AddBook";
	}

	/**
	 * Method used to insert book in Book Inventory
	 * 
	 * @param book
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "onAdd")
	public String onAdd(@ModelAttribute("book") BookInventory book, Model model) {
		try {
			book = service.insertBook(book);
			model.addAttribute("message",
					"Book with bookId:" + book.getBookId() + " updated");
		} catch (LibraryException e) {
			model.addAttribute("message", e.getMessage());
			return "Error";
		}
		return "Success";
	}

	/**
	 * Method used for validating user
	 * 
	 * @param model
	 * @param userName
	 * @param password
	 * @return
	 */
	@RequestMapping(value = "/login.htm", method = RequestMethod.POST)
	public String login(Model model, @RequestParam("userName") String userName,
			@RequestParam("password") String password) {
		try {
			int i = service.validateUser(userName, password);
			model.addAttribute("userName", userName);
			if (i == 0)
				return "StudentOperation";
			else
				return "LibrarianOperation";
		} catch (LibraryException e) {
			model.addAttribute("message", e.getMessage());
			return "Error";
		}
	}

	/**
	 * Method for handling show all book request
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("/showAll.htm")
	public String showAllBooks(Model model) {
		try {
			model.addAttribute("bookList", service.getAllBooks());
			return "BookSearch";
		} catch (LibraryException e) {
			model.addAttribute("message", e.getMessage());
			return "Error";
		}
	}

	/**
	 * Method redirects request to sign up page
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("signUp.htm")
	public String newUser(Model model) {
		model.addAttribute("user", new Users());
		model.addAttribute("librarian", new String[] { "Please select", "true",
				"false" });
		return "SignUp";
	}

	/**
	 * Takes data of new user and persist in table
	 * 
	 * @param model
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/signUp.htm", method = RequestMethod.POST)
	public String signUp(Model model, @ModelAttribute("user") Users user) {
		try {
			user = service.addUser(user);
			model.addAttribute("message",
					"User added with user Id = " + user.getUserId());
			return "Success";
		} catch (LibraryException e) {
			model.addAttribute("message", e.getMessage());
			return "Error";
		}

	}

	/**
	 * Method used for requesting book by student
	 * 
	 * @param model
	 * @param bookId
	 * @return
	 */
	@RequestMapping("/requestBook.htm")
	public String requestBook(Model model, @RequestParam("bookId") String bookId) {

		try {
			BookRegistration bookRequest = new BookRegistration();
			bookRequest.setBookId(bookId);
			bookRequest.setUserId(service.getUserDetails().getUserId());
			bookRequest.setRegistrationDate(Date.valueOf(LocalDate.now()));
			bookRequest = service.requestBook(bookRequest);
			model.addAttribute(
					"message",
					"Book is requested with Registration id - "
							+ bookRequest.getRegistrationId());
			return "Success";
		} catch (LibraryException e) {
			model.addAttribute("message", e.getMessage());
			return "Error";
		}

	}

}
