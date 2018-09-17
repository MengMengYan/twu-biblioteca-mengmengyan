package com.twu.biblioteca.itemSystem;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Inventory {
    private Map<String, Book> availableBooks;
    private Map<String, Book> completeBooks;

    private Map<String, Movie> availableMovies;
    private Map<String, Movie> completeMovies;

    public Inventory(Map<String, Book> books, Map<String, Movie> movies) {
        this.availableBooks = books;
        this.completeBooks = new HashMap<>();
        this.completeBooks.putAll(books);

        this.availableMovies = movies;
        this.completeMovies = new HashMap<>();
        this.completeMovies.putAll(movies);
    }


    public Collection<Book> getBooks() {
        return availableBooks.values();
    }

    public Collection<Movie> getMovies() {
        return availableMovies.values();
    }

    public boolean checkoutBook(String title) {
        if (availableBooks.containsKey(title)) {
            availableBooks.remove(title);
            return true;
        }
        return false;
    }

    public boolean checkoutMovie(String title) {
        if (availableMovies.containsKey(title)) {
            availableMovies.remove(title);
            return true;
        }
        return false;
    }

    public boolean checkin(String title) {
        if (completeBooks.containsKey(title)) {
            this.availableBooks.put(title, completeBooks.get(title));
            return true;
        }
        return false;
    }
}
