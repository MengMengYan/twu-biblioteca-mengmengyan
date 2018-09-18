package com.twu.biblioteca.navigation;

import com.twu.biblioteca.itemSystem.Inventory;
import com.twu.biblioteca.roles.Role;

public class MenuCommand implements Command {
    @Override
    public String execute(Inventory inventory, String title, Role role) {
        switch (role.getRoleType()) {
            case USER:
                return "Menu - Opens menu\n" +
                        "Login - Log into your account\n" +
                        "List Books - Lists all available books\n" +
                        "List Movies - Lists all available movies\n" +
                        "Checkout book [BOOK TITLE] - checkout a book\n" +
                        "Checkout movie [BOOK TITLE] - checkout a movie\n" +
                        "Checkin [BOOK TITLE] - checkin a book\n" +
                        "User Information - show user information\n" +
                        "Quit - Quits Biblioteca";
            case LIBRARIAN:
                return "Menu - Opens menu\n" +
                        "Login - Log into your account\n" +
                        "List Books - Lists all available books\n" +
                        "List Movies - Lists all available movies\n" +
                        "Checkout book [BOOK TITLE] - checkout a book\n" +
                        "Checkout movie [BOOK TITLE] - checkout a movie\n" +
                        "Checkin [BOOK TITLE] - checkin a book\n" +
                        "List Borrowers - Lists books with respective borrowers\n" +
                        "Quit - Quits Biblioteca";
            default:
                return "Menu - Opens menu\n" +
                        "Login - Log into your account\n" +
                        "List Books - Lists all available books\n" +
                        "List Movies - Lists all available movies\n" +
                        "Quit - Quits Biblioteca";
        }

    }
}
