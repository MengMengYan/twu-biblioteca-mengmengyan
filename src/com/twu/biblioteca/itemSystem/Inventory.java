package com.twu.biblioteca.itemSystem;

import com.twu.biblioteca.roles.Role;

import java.util.*;

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

    public boolean checkoutBook(String title, Role user) {
        if (availableBooks.containsKey(title)) {
            availableBooks.remove(title);
            completeBooks.get(title).checkout(user);
            return true;
        }
        return false;
    }

    public boolean checkoutMovie(String title, Role user) {
        if (availableMovies.containsKey(title)) {
            availableMovies.remove(title);
            completeMovies.get(title).checkout(user);
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

    public List<Book> getBookBorrowerList() {
        LinkedList<Book> borrowedBooks = new LinkedList<>();

        for (Book book : completeBooks.values()) {
            if (!book.isCheckedin()) {
                borrowedBooks.add(book);
            }
        }

        return borrowedBooks;
    }
}
