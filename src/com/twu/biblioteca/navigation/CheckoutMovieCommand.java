package com.twu.biblioteca.navigation;

import com.twu.biblioteca.itemSystem.Inventory;
import com.twu.biblioteca.roles.RoleType;

public class CheckoutMovieCommand implements Command {
    @Override
    public String execute(Inventory inventory, String title, RoleType role) {
        if (role.equals(RoleType.GUEST))
            return "Please, log in!";


        boolean checkedOut = inventory.checkoutMovie(title);
        if (checkedOut) {
            return "Thank you! Enjoy the movie";
        }
        return "That movie is not available";
    }
}
