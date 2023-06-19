package com.pedrovsn.di.app;

import com.pedrovsn.di.ApplicationContext;
import com.pedrovsn.di.app.domain.Book;
import com.pedrovsn.di.app.service.BookService;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws Exception {
        ApplicationContext applicationContext = new ApplicationContext();
        BookService instance = applicationContext.getInstance(BookService.class);
        Book save = instance.save(new Book(null, "The Idiot", "Fyodor Dostoevsky"));
        System.out.println(save);
    }
}