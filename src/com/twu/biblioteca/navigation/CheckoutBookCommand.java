package com.twu.biblioteca.navigation;

import com.twu.biblioteca.bookSystem.Inventory;

public class CheckoutBookCommand implements Command {
    @Override
    public String execute(Inventory inventory, String book) {
        boolean checkedOut = inventory.checkout(book);
        if (checkedOut) {
            return "Thank you! Enjoy the book";
        }
        return "";
    }
}
