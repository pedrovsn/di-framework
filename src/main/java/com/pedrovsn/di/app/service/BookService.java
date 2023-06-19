package com.pedrovsn.di.app.service;

import com.pedrovsn.di.Autowired;
import com.pedrovsn.di.app.domain.Book;
import com.pedrovsn.di.app.repository.BookRepository;

import java.util.Optional;

public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public BookService(){}

    public Book save(Book book) {
        return bookRepository.save(book);
    }

    public Optional<Book> getBook(String id) {
        return bookRepository.findById(id);
    }
}
