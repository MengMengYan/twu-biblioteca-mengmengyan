package com.twu.biblioteca.itemSystem;

import com.twu.biblioteca.roles.Role;

public abstract class Item {
    private boolean isCheckedin;
    private String borrower;

    public Item() {
        isCheckedin = true;
    }

    public abstract String getDetails();

    public boolean checkout(Role user) {
        if (isCheckedin) {
            isCheckedin = false;
            borrower = user.getUsername();
            return true;
        } else {
            return false;
        }
    }

    public boolean checkin() {
        if (isCheckedin) {
            return false;
        } else {
            isCheckedin = true;
            return true;
        }
    }

    public boolean isCheckedin() {
        return isCheckedin;
    }

    public String getBorrower() {
        return borrower;
    }
}
