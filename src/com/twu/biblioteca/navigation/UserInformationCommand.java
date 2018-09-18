package com.twu.biblioteca.navigation;

import com.twu.biblioteca.itemSystem.Inventory;
import com.twu.biblioteca.roles.Role;
import com.twu.biblioteca.roles.User;

public class UserInformationCommand implements Command {
    @Override
    public String execute(Inventory inventory, String title, Role role) {
        switch (role.getRoleType()) {
            case LIBRARIAN:
                return "You may log in as a guest";
            case GUEST:
                return "Public guest accounts do not have information stored";
        }
        return ((User) role).getUserInformation();
    }
}
