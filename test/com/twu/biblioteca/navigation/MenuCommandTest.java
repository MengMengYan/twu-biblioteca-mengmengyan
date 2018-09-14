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
        assertEquals("Menu - Opens menu\tList Books - Lists all available books\tQuit - Quits Biblioteca", this.testee.execute(null, null));
    }
}
