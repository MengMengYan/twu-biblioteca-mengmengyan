package com.twu.biblioteca.bookSystem;

import java.util.HashMap;

public class Inventory {
    HashMap<String,Book> availableBooks;
    HashMap<String,Book> completeBooks;

    public Inventory(HashMap<String,Book> books) {
        this.availableBooks = books;
        this.completeBooks = (HashMap<String,Book>)books.clone();
    }


    public Object getBookList() {
        String bookList = "";
        for(Book book : availableBooks.values()) {
            bookList += book.getDetails() + "\n";
        }

        return bookList.trim();
    }

    public String checkout(String title) {
        if(availableBooks.containsKey(title)) {
            availableBooks.remove(title);
            return "Thank you! Enjoy the book";
        }
        return "That book is not available";
    }

    public String checkin(String title) {
        if(completeBooks.containsKey(title)) {
            this.availableBooks.put(title, completeBooks.get(title));
            return "Thank you for returning the book";
        }
        return "";
    }
}
