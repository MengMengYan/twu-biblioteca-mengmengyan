package com.twu.biblioteca.navigation;

import com.twu.biblioteca.itemSystem.Inventory;

public class WelcomeCommand implements Command {

    @Override
    public String execute(Inventory inventory, String book) {
        return "Welcome to Biblioteca";
    }
}
