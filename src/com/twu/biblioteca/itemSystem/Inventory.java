package com.twu.biblioteca.itemSystem;

import com.twu.biblioteca.roles.Role;

import java.util.*;

public class Inventory {
    private Map<String, Item> availableBooks;
    private Map<String, Item> completeBooks;

    private Map<String, Item> availableMovies;
    private Map<String, Item> completeMovies;

    public Inventory(Map<String, Item> books, Map<String, Item> movies) {
        this.availableBooks = books;
        this.completeBooks = new HashMap<>();
        this.completeBooks.putAll(books);

        this.availableMovies = movies;
        this.completeMovies = new HashMap<>();
        this.completeMovies.putAll(movies);
    }


    public Collection<Item> getBooks() {
        return availableBooks.values();
    }

    public Collection<Item> getMovies() {
        return availableMovies.values();
    }

    public boolean checkoutBook(String title, Role user) {
        return checkout(title, user, availableBooks, completeBooks);
    }

    public boolean checkoutMovie(String title, Role user) {
        return checkout(title, user, availableMovies, completeMovies);
    }

    private boolean checkout(String title, Role user, Map<String, Item> availableItems, Map<String, Item> completeItems) {
        if (availableItems.containsKey(title)) {
            availableItems.remove(title);
            completeItems.get(title).checkout(user);
            return true;
        }
        return false;
    }


    public boolean checkin(String title) {
        if (completeBooks.containsKey(title)) {
            this.availableBooks.put(title, completeBooks.get(title));
            this.completeBooks.get(title).checkin();
            return true;
        }
        return false;
    }

    public List<Item> getBookBorrowerList() {
        LinkedList<Item> borrowedBooks = new LinkedList<>();

        for (Item book : completeBooks.values()) {
            if (!book.isCheckedin()) {
                borrowedBooks.add(book);
            }
        }

        return borrowedBooks;
    }
}
