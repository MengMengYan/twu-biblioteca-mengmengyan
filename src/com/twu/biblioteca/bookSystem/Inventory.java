package com.twu.biblioteca.bookSystem;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Inventory {
    private Map<String, Book> availableBooks;
    private Map<String, Book> completeBooks;

    public Inventory(Map<String, Book> books) {
        this.availableBooks = books;
        this.completeBooks = new HashMap<>();
        this.completeBooks.putAll(books);
    }


    public Collection<Book> getBooks() {
        return availableBooks.values();
    }

    public boolean checkout(String title) {
        if (availableBooks.containsKey(title)) {
            availableBooks.remove(title);
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
