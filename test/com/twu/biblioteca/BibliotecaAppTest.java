package com.twu.biblioteca;


import com.twu.biblioteca.navigation.Command;
import com.twu.biblioteca.navigation.ListBookCommand;
import com.twu.biblioteca.navigation.MenuCommand;
import com.twu.biblioteca.navigation.QuitCommand;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BibliotecaAppTest {

    @Test
    public void testListBooks() {
        Command outputCommand = BibliotecaApp.create("List Books");

        assertEquals(ListBookCommand.class, outputCommand.getClass());
    }

    @Test
    public void testQuit() {
        Command outputCommand = BibliotecaApp.create("Quit");

        assertEquals(QuitCommand.class, outputCommand.getClass());
    }

    @Test
    public void testMenu() {
        Command outputCommand = BibliotecaApp.create("Menu");

        assertEquals(MenuCommand.class, outputCommand.getClass());
    }
}
