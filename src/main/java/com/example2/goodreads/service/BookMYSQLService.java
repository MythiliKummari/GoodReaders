package com.example2.goodreads.service;
import com.example2.goodreads.model.Book;
import com.example2.goodreads.model.BookRowMappers;
import com.example2.goodreads.repository.BookRepository;


import java.util.List;
import java.util.ArrayList;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
@Service
public class BookMYSQLService {
	@Autowired
    private JdbcTemplate db;
	
	public ArrayList<Book> getBooks()
    {
    List<Book> bookList=db.query("select * from book", new BookRowMappers());
   	ArrayList<Book> books=new ArrayList<>(bookList);
   	return books;	 
    }
   public Book getBookById(int bookId)
    {
    	try 
    	{
   	     Book book=db.queryForObject("select * from book where id= ?",new BookRowMappers(),bookId);
          return book;
    	}
    	catch(Exception e)
    	{
    	 throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    	}
    }
     public Book addBook(Book book)
    {
     	db.update("insert into book(name,imageUrl) values(?,?)",book.getName(),book.getImageUrl());
    	Book savedBook=db.queryForObject("select * from book where name=? and imageUrl=?",new BookRowMappers(),book.getName(),book.getImageUrl());
        return savedBook;
         }
     public Book updateBook(int bookId, Book book)
    {
    	if(book.getName()!=null)
    	{
    		db.update("update book set name=? where id=?", book.getName(),bookId);
    	}
    	if(book.getImageUrl()!=null)
    	{
    		db.update("update book set imageUrl=? where id=?", book.getImageUrl(),bookId);
    	}
    	return getBookById(bookId);
    }
   public void deleteBook(int bookId)
    {
   	  db.update("DELETE FROM book WHERE id=?",bookId);
   	  }
}