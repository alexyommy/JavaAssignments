package com.alexyom.shows.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.alexyom.shows.models.Book;
import com.alexyom.shows.repositories.BookRepository;

@Service
public class BookService {
	// dependency inject our repository so the service essentially has access to all methods in the repository interface
	private BookRepository bRepo;
	
	public BookService(BookRepository repo) {
		this.bRepo = repo;
	}
	
	//Get all Books
	public List<Book> getAllBooks(){
		return this.bRepo.findAll();
	}
	
	//Get one Book
	public Book getSingleBook(Long id) {
		return this.bRepo.findById(id).orElse(null);
	}
	
	//Create a Book
	public Book createBook(Book newBook) {
		return this.bRepo.save(newBook);
	}
	
	//Update a Book
	public Book updateBook(Book book) {
		return this.bRepo.save(book);
	}
	
	//Delete a Book
	public void deleteBook(Long id) {
		this.bRepo.deleteById(id);
	}
	
}
