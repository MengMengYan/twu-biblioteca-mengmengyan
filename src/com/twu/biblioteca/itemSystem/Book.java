package com.twu.biblioteca.itemSystem;

public class Book {
    private String title;
    private String author;
    private int publishedYear;

    public Book(String title, String author, int publishedYear) {
        this.title = title;
        this.author = author;
        this.publishedYear = publishedYear;
    }


    public String getDetails() {
        return title + "\t|\t" + author + "\t|\t" + publishedYear;
    }
}
