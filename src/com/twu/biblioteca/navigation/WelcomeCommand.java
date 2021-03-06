package com.twu.biblioteca.navigation;

import com.twu.biblioteca.itemSystem.Inventory;
import com.twu.biblioteca.roles.Role;

public class WelcomeCommand implements Command {

    @Override
    public String execute(Inventory inventory, String title, Role role) {
        return "Welcome to Biblioteca";
    }
}
