package com.twu.biblioteca.navigation;

import com.twu.biblioteca.itemSystem.Inventory;
import com.twu.biblioteca.roles.Role;
import com.twu.biblioteca.roles.RoleType;

public class CheckoutBookCommand implements Command {
    @Override
    public String execute(Inventory inventory, String title, Role role) {
        if (role.getRoleType().equals(RoleType.GUEST))
            return "Please, log in!";

        boolean checkedOut = inventory.checkoutBook(title, role);
        if (checkedOut) {
            return "Thank you! Enjoy the book";
        }
        return "That book is not available";
    }
}
