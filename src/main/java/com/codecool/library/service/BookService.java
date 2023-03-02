package com.codecool.library.service;

import com.codecool.library.repository.BookDao;
import com.codecool.library.repository.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    private BookDao bookDao;
    @Autowired
    public BookService(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    public void addBook(Book book) {
        bookDao.addBook(book);
    }

    public List<Book> getAllBooks() {
        return bookDao.getAllBooks();
    }

    public long numberOfBooksInGenre(String genre) {
        return bookDao.numberOfBooksInGenre(genre);
    }

    public List<Book> listBooksByWritersBirthPlace(String birthPlace) {
        return bookDao.listBooksByWritersBirthPlace(birthPlace);
    }


    public List<String> listAllBorrowedBooks() {
        return bookDao.listAllBorrowedBooks();
    }
}
