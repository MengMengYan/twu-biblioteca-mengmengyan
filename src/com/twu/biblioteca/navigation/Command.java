package com.twu.biblioteca.navigation;

import com.twu.biblioteca.itemSystem.Inventory;

public interface Command {
    String execute(Inventory inventory, String book);
}
