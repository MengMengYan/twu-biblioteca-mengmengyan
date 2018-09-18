package com.twu.biblioteca.navigation;

import com.twu.biblioteca.itemSystem.Inventory;
import com.twu.biblioteca.itemSystem.Item;
import com.twu.biblioteca.roles.Role;

import java.util.Collection;

public class ListBookCommand implements Command {
    @Override
    public String execute(Inventory inventory, String title, Role role) {
        Collection<Item> books = inventory.getBooks();
        if (books.isEmpty()) {
            return "No Book available";
        }

        StringBuilder bookList = new StringBuilder();
        for (Item inventoryBook : books) {
            bookList.append(inventoryBook.getDetails()).append("\n");
        }
        return bookList.toString().trim();
    }
}
