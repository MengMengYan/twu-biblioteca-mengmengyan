package com.twu.biblioteca.navigation;

import com.twu.biblioteca.bookSystem.Inventory;

public class InvalidCommand implements Command {
    @Override
    public String execute(Inventory inventory) {
        return "Select a valid option!";
    }
}
