package com.example2.goodreads.controller;
import com.example2.goodreads.service.BookJpaService;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example2.goodreads.model.Book;
@RestController
public class BookController {
	@Autowired
	public BookJpaService bookService;
	@GetMapping("/books")
		public ArrayList<Book> getBooks()
		{
			return bookService.getBooks();
		}
	@GetMapping("books/{bookId}")
	public Book getBookById(@PathVariable("bookId") int bookId)
	{
		return bookService.getBookById(bookId);
	}
	@PostMapping("/books")
	public Book addBook(@RequestBody Book book)
	{
	return bookService.addBook(book);	
	}
	@PutMapping("/books/{bookId}")
	public Book updateBook(@PathVariable("bookId") int bookId, @RequestBody Book book)
	{
		return bookService.updateBook(bookId, book);
	}
	@DeleteMapping("/books/{bookId}")
	public void deleteBook(@PathVariable("bookId") int bookId)
	{
		bookService.deleteBook(bookId);
	}
}
