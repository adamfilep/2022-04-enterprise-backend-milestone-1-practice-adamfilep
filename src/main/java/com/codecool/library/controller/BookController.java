package com.codecool.library.controller;

import com.codecool.library.repository.model.Book;
import com.codecool.library.service.BookService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class BookController {
    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("/book")
    public void addBook(@RequestBody Book book) {
        bookService.addBook(book);
    }
}
