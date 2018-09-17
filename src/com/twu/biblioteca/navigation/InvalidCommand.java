package com.twu.biblioteca.navigation;

import com.twu.biblioteca.itemSystem.Inventory;

public class InvalidCommand implements Command {
    @Override
    public String execute(Inventory inventory, String book) {
        return "Select a valid option!";
    }
}
