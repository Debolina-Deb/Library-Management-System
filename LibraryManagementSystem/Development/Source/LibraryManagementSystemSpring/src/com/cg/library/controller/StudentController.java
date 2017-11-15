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
import com.cg.library.service.LibraryService;
import com.cg.library.util.Constants;
import com.cg.library.util.RequestPage;

/***********************************************************************************
 * File Name: StudentController 
 * Package Name: com.cg.lms.controller
 * Description: Student controller controls the functionalities of Student
 * Version: 1.0 
 * Restrictions: N/A 
 * Date: 14/11/2017
 * 
 * @author - parpatid
 ***********************************************************************************/
@Controller
public class StudentController {
	@Autowired
	LibraryService studentService;

	/**
	 * Shows all book requests
	 * 
	 * @param model
	 *            - Model object used to send attributes
	 * @return
	 */
	@RequestMapping("/showAll.htm")
	public String showAllBooks(Model model) {
		try {
			model.addAttribute("books", studentService.getAllBooks());
			return RequestPage.BookSearch;
		} catch (Exception e) {
			model.addAttribute(Constants.message, e.getMessage());
			return RequestPage.Error;
		}
	}

	/**
	 * Book request placed by student
	 * 
	 * @param model
	 *            - Model object used to send attributes
	 * @param bookId
	 *            - Book Id for book requested by student
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
			model.addAttribute(Constants.message, Constants.bookRequestMessage
					+ bookRequest.getRegistrationId());
			return RequestPage.Success;
		} catch (Exception e) {
			model.addAttribute(Constants.message, e.getMessage());
			return RequestPage.Error;
		}
	}

	/**
	 * Redirects to page for searching by author
	 * 
	 * @param model
	 *            - Model object used to send attributes
	 * @return
	 */
	@RequestMapping("/searchByAuthor")
	public String searchBookByAuthor(Model model) {
		model.addAttribute("input", "0");
		return RequestPage.SearchByAuthor;
	}

	/**
	 * Search book by author name
	 * 
	 * @param model
	 *            - Model object used to send attributes
	 * @param authorName
	 *            - Author name which will be used to search Book
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/authorSearch", method = RequestMethod.POST)
	public String searchByAuthor(Model model,
			@RequestParam("authorName") String authorName) {
		try {
			List<BookInventory> books = studentService
					.searchBookByAuthor(authorName);
			model.addAttribute("books", books);
			return RequestPage.BookSearch;
		} catch (Exception e) {
			model.addAttribute(Constants.message, e.getMessage());
			return RequestPage.Error;
		}
	}

	/**
	 * Method used to redirect page to searchBook
	 * 
	 * @return
	 */
	@RequestMapping("/searchByName")
	public String searchBookByName() {
		return RequestPage.SearchByAuthor;
	}

	/**
	 * Search book by book name
	 * 
	 * @param model
	 *            - Model object used to send attributes
	 * @param bookName
	 *            - Book name which will be used to search Book
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/bookSearch", method = RequestMethod.POST)
	public String searchByBook(Model model,
			@RequestParam("bookName") String bookName) {
		try {
			List<BookInventory> books = studentService
					.searchBookByName(bookName);
			model.addAttribute("books", books);
			return RequestPage.BookSearch;
		} catch (Exception e) {
			model.addAttribute(Constants.message, e.getMessage());
			return RequestPage.Error;
		}
	}

	/**
	 * Method used to redirect to Student operation page
	 * 
	 * @return
	 */
	@RequestMapping("/studentHome")
	public String studentHome() {
		return RequestPage.StudentOperation;
	}
}
