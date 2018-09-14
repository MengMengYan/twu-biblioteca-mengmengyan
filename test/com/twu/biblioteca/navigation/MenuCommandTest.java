package com.twu.biblioteca.navigation;

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
    public void shouldReturnMenu() {
        assertEquals("Menu - Opens menu\n" +
                "List Books - Lists all available books\n" +
                "Checkout [BOOK TITLE] - checkout a book\n" +
                "Checkin [BOOK TITLE] - checkin a book\n" +
                "Quit - Quits Biblioteca", this.testee.execute(null, null));
    }
}
