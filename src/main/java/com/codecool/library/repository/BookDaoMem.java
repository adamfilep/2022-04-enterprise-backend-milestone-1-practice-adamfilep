package com.codecool.library.repository;

import com.codecool.library.repository.model.Book;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class BookDaoMem implements BookDao {
    
    private List<Book> bookList;

    public BookDaoMem(List<Book> bookList) {
        this.bookList = bookList;
    }

    public BookDaoMem() {
        bookList = new ArrayList<>();
    }

    @Override
    public void addBook(Book book) {
        bookList.add(book);
    }

    @Override
    public List<Book> getAllBooks() {
        return bookList;
    }

    @Override
    public int numberOfBooksInGenre(String genre) {
        int counter = 0;
        for (Book book : bookList) {
            if (book.getGenre().equals(genre)) {
                counter++;
            }
        }
        return counter;
    }

    @Override
    public List<Book> listBooksByWritersBirthPlace(String birthPlace) {
        List<Book> booksWithBirthPlace = new ArrayList<>();
        return null;
    }

    @Override
    public List<String> listAllBorrowedBooks() {
        List<String> allBorrowedBooks = new ArrayList<>();
        for (Book book : bookList) {
            if (book.getNumberOwnedByLibrary() - book.getNumberBorrowed() == 0) {
                allBorrowedBooks.add(book.getTitle());
            }
        }
        return allBorrowedBooks;
    }
}
