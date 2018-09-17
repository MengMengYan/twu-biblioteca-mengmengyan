package com.twu.biblioteca.navigation;

import com.twu.biblioteca.itemSystem.Inventory;
import com.twu.biblioteca.roles.RoleType;

import java.util.Scanner;

public class LoginCommand implements Command {
    @Override
    public String execute(Inventory inventory, String title, RoleType role) {
        switch (role) {
            case USER:
                return "You are now logged in as a user";
            case LIBRARIAN:
                return "You are now logged in as a librarian";
            default:
                return "You did not log in successfully";
        }
    }

    private String getStringInput(Scanner in) {
        return in.nextLine().trim();
    }
}
