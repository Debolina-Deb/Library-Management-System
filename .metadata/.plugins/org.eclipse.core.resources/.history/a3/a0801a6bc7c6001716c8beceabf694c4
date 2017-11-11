package com.cg.library.controller;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cg.library.entities.BookInventory;
import com.cg.library.entities.BookRegistration;
import com.cg.library.service.ILibraryService;
/**
 * Student Controller controls functionalities of student
 * 
 * @author parpatid
 */
@Controller
public class StudentController {

	/**
	 * Service layer interface reference
	 */
	@Autowired
	ILibraryService studentService;

	/**
	 * Method for handling show all book request
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("/showAll.htm")
	public String showAllBooks(Model model) {
		try {
			model.addAttribute("bookList", studentService.getAllBooks());
			return "BookSearch";
		} catch (Exception e) {
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
			bookRequest.setUserId(studentService.getUserDetails().getUserId());
			bookRequest.setRegistrationDate(Date.valueOf(LocalDate.now()));
			bookRequest = studentService.requestBook(bookRequest);
			model.addAttribute(
					"message",
					"Book is requested with Registration id - "
							+ bookRequest.getRegistrationId());
			return "Success";
		} catch (Exception e) {
			model.addAttribute("message", e.getMessage());
			return "Error";
		}

	}

	/**
	 * Method to redirect page to search by author
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("/searchByAuthor")
	public String searchBookByAuthor(Model model) {
		model.addAttribute("input", "0");
		return "SearchByAuthor";
	}

	/**
	 * Method to search book by author name
	 * 
	 * @param model
	 * @param author
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/authorSearch", method = RequestMethod.POST)
	public String searchByAuthor(Model model,
			@RequestParam("author") String author) {
		try {
			List<BookInventory> books = studentService
					.searchBookByAuthor(author);
			model.addAttribute("bookList", books);
			return "BookSearch";
		} catch (Exception e) {
			model.addAttribute("message", e.getMessage());
			return "Error";
		}

	}

	/**
	 * Method used to redirect page to searchBook
	 * 
	 * @return
	 */
	@RequestMapping("/searchByName")
	public String searchBookByName() throws Exception {
		return "SearchByAuthor";
	}

	/**
	 * Method used to search by book name
	 * 
	 * @param model
	 * @param bookName
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/bookSearch", method = RequestMethod.POST)
	public String searchByBook(Model model,
			@RequestParam("bookName") String bookName) {
		try {
			List<BookInventory> books = studentService.searchBookByName(bookName);
			model.addAttribute("bookList", books);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "BookSearch";
	}
}
