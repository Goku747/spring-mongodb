package com.javatechie.spring.mongo.api.resource;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.javatechie.spring.mongo.api.model.Book;
import com.javatechie.spring.mongo.api.repository.Bookrepo;

@RestController
public class BookController {
	@Autowired
	Bookrepo repo;

	@PostMapping("/savebook")
	public Book CreateBook(@RequestBody Book book) {
		book = repo.save(book);
		return book;
	}

	@DeleteMapping("/delete/{id}")
	public String DeleteBook(@PathVariable int id) {
		repo.deleteById(id);
		return "Book with the id" + " " + id + " " + "deleted successfully";
	}

	@PutMapping("/EditBook")
	public String EditBook(@RequestBody Book book) {
		repo.save(book);
		return "Book Edited Successfully";
	}

	@RequestMapping(value = "all", method = RequestMethod.GET)
	public List<Book> ViewAllBooks() {
		return repo.findAll();
	}

}
