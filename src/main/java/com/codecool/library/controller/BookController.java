package com.codecool.library.controller;

import com.codecool.library.repository.model.Book;
import com.codecool.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {
    private BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping()
    public void addBook(@RequestBody Book book) {
        bookService.addBook(book);
    }

    @GetMapping()
    public int numberOfBooksByGenre(@RequestParam("genre") String genre) {
        return bookService.numberOfBooksInGenre(genre);
    }

    @GetMapping("/allBorrowed")
    public List<String> listAllBorrowedBooks() {
        return bookService.listAllBorrowedBooks();
    }
}
