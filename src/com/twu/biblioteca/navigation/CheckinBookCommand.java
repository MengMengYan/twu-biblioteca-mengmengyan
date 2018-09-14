package com.twu.biblioteca.navigation;

import com.twu.biblioteca.bookSystem.Inventory;

public class CheckinBookCommand implements Command {
    @Override
    public String execute(Inventory inventory, String book) {
        if (inventory.checkin(book)) {
            return "Thank you for returning the book";
        } else {
            return "";
        }
    }
}
