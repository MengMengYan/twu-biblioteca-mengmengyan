package com.twu.biblioteca.navigation;

import com.twu.biblioteca.itemSystem.Inventory;
import com.twu.biblioteca.roles.RoleType;

public interface Command {

    String execute(Inventory inventory, String title, RoleType role);
}
