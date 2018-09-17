package com.twu.biblioteca.navigation;

import com.twu.biblioteca.itemSystem.Book;
import com.twu.biblioteca.itemSystem.Inventory;

import java.util.Collection;

public class ListBookCommand implements Command {
    @Override
    public String execute(Inventory inventory, String book) {
        Collection<Book> books = inventory.getBooks();
        if (books.isEmpty()) {
            return "No Book available";
        }

        StringBuilder bookList = new StringBuilder();
        for (Book inventoryBook : books) {
            bookList.append(inventoryBook.getDetails()).append("\n");
        }
        return bookList.toString().trim();
    }
}
