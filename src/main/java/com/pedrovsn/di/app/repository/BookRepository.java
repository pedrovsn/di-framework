package com.pedrovsn.di.app.repository;

import com.pedrovsn.di.app.domain.Book;

import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class BookRepository {

    private static final ConcurrentHashMap<String, Book> DB = new ConcurrentHashMap<>();

    public Book save(Book book) {
        final String id = UUID.randomUUID().toString();
        final Book entity = new Book(id, book.title(), book.author());
        DB.put(id, entity);
        return entity;
    }

    public Optional<Book> findById(final String id) {
        if (DB.contains(id)) {
            return Optional.of(DB.get(id));
        } else {
            return Optional.empty();
        }
    }
}
