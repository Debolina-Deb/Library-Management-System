package com.cg.library.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cg.library.entities.BookInventory;
import com.cg.library.entities.Users;
import com.cg.library.service.ILibraryService;
import com.cg.library.util.Constants;

/**
 * Librarian Controller controls functionalities of librarian
 * 
 * @author parpatid
 */
@Controller
public class LibrarianController {

	/**
	 * Service layer interface reference
	 */
	@Autowired
	ILibraryService librarianService;

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
			int i = librarianService.validateUser(userName, password);
			model.addAttribute("userName", userName);
			if (i == 0)
				return "StudentOperation";
			else
				return "LibrarianOperation";
		} catch (Exception e) {
			model.addAttribute(Constants.M, e.getMessage());
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
		model.addAttribute("librarian", Constants.isLibrarianList);
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
	public String signUp(Model model,
			@ModelAttribute("user") @Valid Users user, BindingResult result) {
		try {
			if (result.hasErrors()) {
				model.addAttribute("librarian",Constants.isLibrarianList);
				return "SignUp";
			} else {
				user = librarianService.addUser(user);
				model.addAttribute(Constants.M,Constants.M1
						+ user.getUserId());
				return "Success";
			}
		} catch (Exception e) {
			model.addAttribute(Constants.M, e.getMessage());
			return "Error";
		}

	}

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
			List<BookInventory> allBook = librarianService.getAllBooks();
			model.addAttribute("allBook", allBook);
			model.addAttribute("userName", userName);
		} catch (Exception le) {
			model.addAttribute(Constants.M, le.getMessage());
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
			BookInventory book = librarianService.deleteBookById(bookId);
			model.addAttribute(Constants.M,
					Constants.M5 + book.getBookId());
			model.addAttribute("userName", "parag");
		} catch (Exception e) {
			model.addAttribute(Constants.M, e.getMessage());
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
	@RequestMapping(value = "/checkBook", method = RequestMethod.POST)
	public String addUpdate(@RequestParam("bookId") String bookId, Model model) {
		try {
			BookInventory book = librarianService.getBookById(bookId);
			if (book == null) {
				model.addAttribute("bookId", bookId);
				model.addAttribute("book", new BookInventory());
				return "AddBook";
			} else {
				model.addAttribute("bookId", bookId);
				model.addAttribute("book", book);
				return "AddBook";
			}
		} catch (Exception e) {
			model.addAttribute(Constants.M, e.getMessage());
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
	public String onAdd(@ModelAttribute("book") @Valid BookInventory book,
			BindingResult result, Model model) {
		try {
			if (result.hasErrors()) {
				model.addAttribute("bookId", book.getBookId());
				return "AddBook";
			} else {
				book = librarianService.insertBook(book);
				model.addAttribute(Constants.M,
						Constants.M2 + book.getBookId());
				return "Success";
			}
		} catch (Exception e) {
			model.addAttribute(Constants.M, e.getMessage());
			return "Error";
		}

	}

	/**
	 * Method used for viewing issue request of student by librarian
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("/pendingRequest.htm")
	public String pendingBook(Model model) {

		try {
			model.addAttribute("reqPList",
					librarianService.getRequestByStatus("pending"));
			return "Issue";
		} catch (Exception e) {
			model.addAttribute(Constants.M, e.getMessage());
			return "Error";
		}

	}

	/**
	 * Method used for viewing issued books registration details librarian
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("/issuedRequest.htm")
	public String issuedBook(Model model) {

		try {
			model.addAttribute("reqIList",
					librarianService.getRequestByStatus("issued"));
			return "Return";
		} catch (Exception e) {
			model.addAttribute(Constants.M, e.getMessage());
			return "Error";
		}

	}

	/**
	 * Method used for issuing books
	 * 
	 * @param model
	 * @param regId
	 * @return
	 */
	@RequestMapping("/issue.htm")
	public String issueBook(Model model, @RequestParam("regId") int regId) {
		try {
			librarianService.issueBook(regId);
			model.addAttribute(Constants.M, Constants.M3+ regId);
			return "Success";
		} catch (Exception e) {
			model.addAttribute(Constants.M, e.getMessage());
			return "Error";
		}

	}

	/**
	 * Method used for returning books
	 * 
	 * @param model
	 * @param regId
	 * @return
	 */
	@RequestMapping("/return.htm")
	public String returnBook(Model model, @RequestParam("regId") int regId) {
		try {

			int fine = librarianService.returnBook(regId);
			if (fine != -1) {
				model.addAttribute(Constants.M, Constants.M4 + fine);
			}
			return "Success";
		} catch (Exception e) {
			model.addAttribute(Constants.M, e.getMessage());
			return "Error";
		}

	}

	/**
	 * Method used to redirect to librarian home page
	 * 
	 * @return
	 */
	@RequestMapping("/librarianHome.htm")
	public String studentHome() {
		return "StudentOperation";
	}

}
