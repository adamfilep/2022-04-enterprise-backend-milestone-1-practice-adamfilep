package com.codecool.library.controller;

import com.codecool.library.repository.model.Book;
import com.codecool.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
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
    public long numberOfBooksByGenre(@RequestParam("genre") String genre) {
        long numberOfBooks = bookService.numberOfBooksInGenre(genre);
        return numberOfBooks;
    }

    @GetMapping("/allBorrowed")
    public List<String> listAllBorrowedBooks() {
        return bookService.listAllBorrowedBooks();
    }
}
