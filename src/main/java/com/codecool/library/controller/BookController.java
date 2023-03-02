package com.codecool.library.controller;

import com.codecool.library.repository.model.Book;
import com.codecool.library.repository.model.Writer;
import com.codecool.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {
    private BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("/book")
    public void addBook(@RequestBody Book book) {
        bookService.addBook(book);
    }

    @GetMapping("/book")
    public long numberOfBooksByGenre(@RequestParam("genre") String genre) {
        long numberOfBooks = bookService.numberOfBooksInGenre(genre);
        return numberOfBooks;
    }

    @GetMapping("/book/allBorrowed")
    public List<String> listAllBorrowedBooks() {
        return bookService.listAllBorrowedBooks();
    }

    @GetMapping("/book/byWriter")
    public List<Book> getBooksByWritersBirthPlace(@RequestParam("writersBirthPlace") String birthPlace) {
        return bookService.listBooksByWritersBirthPlace(birthPlace);
    }

    @PostMapping("/writer")
    public void addWriter(@RequestBody Writer writer) {
        bookService.addWriter(writer);
    }
}
