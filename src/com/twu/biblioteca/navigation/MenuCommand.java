package com.twu.biblioteca.navigation;

public class MenuCommand implements Command {
    @Override
    public String execute() {
        return "Menu - Opens menu\tQuit - Quits Biblioteca";
    }
}
