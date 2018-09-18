package com.twu.biblioteca.navigation;

import com.twu.biblioteca.itemSystem.Inventory;
import com.twu.biblioteca.roles.Role;
import com.twu.biblioteca.roles.RoleType;

public class CheckoutMovieCommand implements Command {
    @Override
    public String execute(Inventory inventory, String title, Role role) {
        if (role.getRoleType().equals(RoleType.GUEST)
                || role.getRoleType().equals(RoleType.LIBRARIAN))
            return "Please, log in!";


        boolean checkedOut = inventory.checkoutMovie(title, role);
        if (checkedOut) {
            return "Thank you! Enjoy the movie";
        }
        return "That movie is not available";
    }
}
