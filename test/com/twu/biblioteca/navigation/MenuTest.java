package com.twu.biblioteca.navigation;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MenuTest {

    @Test
    public void welcomeUserTest() {
        Menu menu = new Menu();
        assertEquals("Welcome to Biblioteca", menu.welcomeUser());
    }
}
