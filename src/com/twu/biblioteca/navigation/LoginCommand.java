package com.twu.biblioteca.navigation;

import com.twu.biblioteca.itemSystem.Inventory;
import com.twu.biblioteca.roles.Role;

public class LoginCommand implements Command {
    @Override
    public String execute(Inventory inventory, String title, Role role) {
        switch (role.getRoleType()) {
            case USER:
                return "You are now logged in as a user";
            case LIBRARIAN:
                return "You are now logged in as a librarian";
            default:
                return "You did not log in successfully";
        }
    }
}
