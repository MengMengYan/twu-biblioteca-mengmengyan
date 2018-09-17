package com.twu.biblioteca.navigation;

import com.twu.biblioteca.itemSystem.Inventory;

public class MenuCommand implements Command {
    @Override
    public String execute(Inventory inventory, String book) {
        return "Menu - Opens menu\n" +
                "List Books - Lists all available books\n" +
                "List Movies - Lists all available movies\n" +
                "Checkout book [BOOK TITLE] - checkout a book\n" +
                "Checkout movie [BOOK TITLE] - checkout a movie\n" +
                "Checkin [BOOK TITLE] - checkin a book\n" +
                "Quit - Quits Biblioteca";
    }
}
