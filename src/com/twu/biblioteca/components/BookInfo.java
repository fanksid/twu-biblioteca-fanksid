package com.twu.biblioteca.components;

/**
 * Created on 16/9/29.
 */
public class BookInfo {
    private String name;
    private String author;
    private String yearPublished;
    private boolean isBorrowed;

    public BookInfo(String name, String author, String yearPublished) {
        this.name = name;
        this.author = author;
        this.yearPublished = yearPublished;
        this.isBorrowed = false;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public String getYearPublished() {
        return yearPublished;
    }

    public void setBorrowed() {
        this.isBorrowed = true;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }
}
