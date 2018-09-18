package com.twu.biblioteca.navigation;

import com.twu.biblioteca.itemSystem.Inventory;
import com.twu.biblioteca.itemSystem.Item;
import com.twu.biblioteca.roles.Role;
import com.twu.biblioteca.roles.RoleType;

import java.util.List;

public class ListBookBorrowerCommand implements Command {
    @Override
    public String execute(Inventory inventory, String title, Role role) {
        if (role.getRoleType().equals(RoleType.GUEST)
                || role.getRoleType().equals(RoleType.USER)) {
            return "Please, log in as a librarian";
        }

        List<Item> borrowedBooks = inventory.getBookBorrowerList();

        StringBuilder bookList = new StringBuilder();

        for (Item book : borrowedBooks) {
            bookList.append(book.getBorrower() + " borrowed " + book.getDetails() + "\n");
        }

        return bookList.toString().trim();
    }
}
