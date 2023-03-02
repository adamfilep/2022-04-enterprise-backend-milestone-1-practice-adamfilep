package com.codecool.library.repository;

import com.codecool.library.repository.model.Book;

import java.util.List;

public interface BookDao {
    void addBook(Book book);

    List<Book> getAllBooks();

    Book findBookById(int id);

    int numberOfBooksInGenre(String genre);

    List<Book> listBooksByWritersBirthPlace(String birthPlace);

    List<String> listAllBorrowedBooks();

}
