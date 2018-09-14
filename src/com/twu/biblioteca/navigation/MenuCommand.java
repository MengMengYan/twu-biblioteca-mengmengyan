package com.twu.biblioteca.navigation;

import com.twu.biblioteca.bookSystem.Inventory;

public class MenuCommand implements Command {
    @Override
    public String execute(Inventory inventory, String book) {
        return "Menu - Opens menu\tList Books - Lists all available books\tQuit - Quits Biblioteca";
    }
}
