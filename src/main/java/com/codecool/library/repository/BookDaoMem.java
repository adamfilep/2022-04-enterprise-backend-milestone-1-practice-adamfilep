package com.codecool.library.repository;

import com.codecool.library.repository.model.Book;
import com.codecool.library.repository.model.Writer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class BookDaoMem implements BookDao {
    
    private List<Book> bookList;
    private List<Writer> writerList = new ArrayList<>();
    Logger log = LoggerFactory.getLogger(BookDaoMem.class);

    public BookDaoMem(List<Book> bookList) {
        this.bookList = bookList;
    }

    public BookDaoMem() {
        bookList = new ArrayList<>();
    }

    @Override
    public void addBook(Book book) {
        log.info("Book added: " + book.getTitle());
        bookList.add(book);
    }

    @Override
    public List<Book> getAllBooks() {
        log.info("Listing all books...");
        return bookList;
    }

    @Override
    public long numberOfBooksInGenre(String genre) {
        int counter = 0;
        for (Book book : bookList) {
            if (book.getGenre().equals(genre)) {
                counter++;
            }
        }
        log.info("Number of books in genre {} : {}", genre, counter);
        return counter;
    }

    @Override
    public List<Book> listBooksByWritersBirthPlace(String birthPlace) {
        List<Book> booksWithBirthPlace = new ArrayList<>();
        log.info("Books with a writer's given birthplace: ");
        Writer writer = null;
        for (Book book : bookList) {
            writer = getWriterByName(book.getWriterName());
            if (writer.getBirthPlace().equals(birthPlace)) {
                booksWithBirthPlace.add(book);
            }
        }
        return booksWithBirthPlace;
    }

    @Override
    public List<String> listAllBorrowedBooks() {
        List<String> allBorrowedBooks = new ArrayList<>();
        for (Book book : bookList) {
            if (book.getNumberOwnedByLibrary() - book.getNumberBorrowed() == 0) {
                allBorrowedBooks.add(book.getTitle());
            }
        }
        log.info("Borrowed books are : {}", allBorrowedBooks);
        return allBorrowedBooks;
    }

    @Override
    public void addWriter(Writer writer) {
        writerList.add(writer);
    }

    public Writer getWriterByName(String name) {
        for (Writer writer : writerList) {
            if (writer.getName().equals(name)) {
                return writer;
            }
        }
        return null;
    }
}
