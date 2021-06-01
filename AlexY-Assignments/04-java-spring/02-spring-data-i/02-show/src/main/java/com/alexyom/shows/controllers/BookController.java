package com.alexyom.shows.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alexyom.shows.models.Book;
import com.alexyom.shows.services.BookService;

@RestController
public class BookController {
	@Autowired
	private BookService bService;
	
	@GetMapping("/")
	public List<Book> index() {
		return this.bService.getAllBooks();
	}
	
	@GetMapping("/{id}")
	public Book getBook(@PathVariable("id") Long id) {
		return this.bService.getSingleBook(id);
	}
	
	@PostMapping("/create")
	public Book create(Book book) {
		return this.bService.createBook(book);
	}
	
	//@RequestMapping("/value="delete/{id}", method=RequestMethod.DELETE)
	@DeleteMapping(value="/delete/{id}")
	public void deleteDog(@PathVariable("id") Long id) {
		this.bService.deleteBook(id);
	}
	
	//@RequestMapping("/value="delete/{id}", method=RequestMethod.PUT)
	@PutMapping("/update/{id}")
	public Book updateBook(@PathVariable("id") Long id, Book updatedBook) {
		return this.bService.updateBook(updatedBook);
	}
	
	
}
