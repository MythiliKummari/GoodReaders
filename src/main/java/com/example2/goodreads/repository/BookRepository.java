package com.example2.goodreads.repository;

import java.util.ArrayList;

import com.example2.goodreads.model.Book;

public interface BookRepository {
	ArrayList<Book> getBooks();
	Book getBookById(int bookId);
	Book addBook(Book book);

}
