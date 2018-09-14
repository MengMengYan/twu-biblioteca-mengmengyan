package com.twu.biblioteca.navigation;

import com.twu.biblioteca.bookSystem.Inventory;

public class QuitCommand implements Command {
    @Override
    public String execute(Inventory inventory, String book) {
        return "See you again";
    }
}
