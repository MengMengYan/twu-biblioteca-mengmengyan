package com.twu.biblioteca.navigation;

import com.twu.biblioteca.itemSystem.Inventory;
import com.twu.biblioteca.roles.Role;
import com.twu.biblioteca.roles.RoleType;

public class CheckinBookCommand implements Command {
    @Override
    public String execute(Inventory inventory, String title, Role role) {

        if (role.getRoleType().equals(RoleType.GUEST))
            return "Please, log in!";

        if (inventory.checkin(title)) {
            return "Thank you for returning the book";
        } else {
            return "That is not a valid book to return";
        }
    }
}
