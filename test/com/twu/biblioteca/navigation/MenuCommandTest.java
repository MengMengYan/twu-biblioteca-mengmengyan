package com.twu.biblioteca.navigation;

import com.twu.biblioteca.roles.RoleType;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MenuCommandTest {
    private Command testee;

    @Before
    public void setUp() {
        this.testee = new MenuCommand();
    }

    @Test
    public void shouldReturnGuestMenu() {
        assertEquals("Menu - Opens menu\n" +
                "Login - Log into your account\n" +
                "List Books - Lists all available books\n" +
                "List Movies - Lists all available movies\n" +
                "Quit - Quits Biblioteca", this.testee.execute(null, null, RoleType.GUEST));
    }

    @Test
    public void shouldReturnUserMenu() {
        assertEquals("Menu - Opens menu\n" +
                "Login - Log into your account\n" +
                "List Books - Lists all available books\n" +
                "List Movies - Lists all available movies\n" +
                "Checkout book [BOOK TITLE] - checkout a book\n" +
                "Checkout movie [BOOK TITLE] - checkout a movie\n" +
                "Checkin [BOOK TITLE] - checkin a book\n" +
                "Quit - Quits Biblioteca", this.testee.execute(null, null, RoleType.USER));
    }

    @Test
    public void shouldReturnLibrarianMenu() {
        assertEquals("Menu - Opens menu\n" +
                "Login - Log into your account\n" +
                "List Books - Lists all available books\n" +
                "List Movies - Lists all available movies\n" +
                "Checkout book [BOOK TITLE] - checkout a book\n" +
                "Checkout movie [BOOK TITLE] - checkout a movie\n" +
                "Checkin [BOOK TITLE] - checkin a book\n" +
                "List Checkouts - Lists all checked out books\n" +
                "Quit - Quits Biblioteca", this.testee.execute(null, null, RoleType.LIBRARIAN));
    }
}
