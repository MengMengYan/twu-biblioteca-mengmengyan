package com.twu.biblioteca.navigation;

import com.twu.biblioteca.itemSystem.Inventory;

public class CheckoutMovieCommand implements Command {
    @Override
    public String execute(Inventory inventory, String title) {
        boolean checkedOut = inventory.checkoutMovie(title);
        if (checkedOut) {
            return "Thank you! Enjoy the movie";
        }
        return "That movie is not available";
    }
}
