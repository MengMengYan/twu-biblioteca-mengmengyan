package com.twu.biblioteca.navigation;

import com.twu.biblioteca.itemSystem.Inventory;
import com.twu.biblioteca.roles.RoleType;

public class InvalidCommand implements Command {
    @Override
    public String execute(Inventory inventory, String title, RoleType role) {
        return "Select a valid option!";
    }
}
