package com.twu.biblioteca.bookSystem;

import java.util.HashMap;

public class Inventory {
    HashMap<String,Book> books;

    public Inventory(HashMap<String,Book> books) {
        this.books = books;
    }


    public Object getBookList() {
        String bookList = "";
        for(Book book : books.values()) {
            bookList += book.getDetails() + "\n";
        }

        return bookList.trim();
    }

    public String checkout(String title) {
        if(books.containsKey(title)) {
            books.remove(title);
            return "Thank you! Enjoy the book";
        }
        return "";
    }
}
