package com.twu.biblioteca.navigation;

import com.twu.biblioteca.bookSystem.Book;
import com.twu.biblioteca.bookSystem.Inventory;

import java.util.Collection;

public class ListBookCommand implements Command {
    @Override
    public String execute(Inventory inventory) {
        Collection<Book> books = inventory.getBooks();
        if (books.isEmpty()) {
            return "No Book available";
        }

        StringBuilder bookList = new StringBuilder();
        for (Book book : books) {
            bookList.append(book.getDetails()).append("\n");
        }
        return bookList.toString().trim();
    }
}
