package com.codecool.library.repository;

import com.codecool.library.repository.model.Book;
import com.codecool.library.repository.model.Writer;

import java.util.List;

public interface BookDao {
    void addBook(Book book);

    List<Book> getAllBooks();

    long numberOfBooksInGenre(String genre);

    List<Book> listBooksByWritersBirthPlace(String birthPlace);

    List<String> listAllBorrowedBooks();

    void addWriter(Writer writer);

}
