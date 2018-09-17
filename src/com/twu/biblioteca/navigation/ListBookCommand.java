package com.twu.biblioteca.navigation;

import com.twu.biblioteca.itemSystem.Book;
import com.twu.biblioteca.itemSystem.Inventory;
import com.twu.biblioteca.roles.RoleType;

import java.util.Collection;

public class ListBookCommand implements Command {
    @Override
    public String execute(Inventory inventory, String title, RoleType role) {
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
