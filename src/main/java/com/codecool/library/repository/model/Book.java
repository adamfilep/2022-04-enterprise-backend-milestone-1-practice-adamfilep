package com.codecool.library.repository.model;

import lombok.Data;

@Data
public class Book {
    private String title;
    private String writerName;
    private String genre;
    private int numberOwnedByLibrary;
    private int numberBorrowed;
}
