package com.twu.biblioteca.itemSystem;

public abstract class Item {
    boolean isCheckedin;

    public Item() {
        isCheckedin = true;
    }

    abstract String getDetails();

    public boolean checkout() {
        if (isCheckedin) {
            isCheckedin = false;
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
}
