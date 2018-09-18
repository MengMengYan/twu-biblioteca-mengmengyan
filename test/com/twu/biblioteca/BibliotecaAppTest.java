package com.twu.biblioteca;


import com.twu.biblioteca.navigation.*;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BibliotecaAppTest {

    @Test
    public void testLogin() {
        Command outputCommand = BibliotecaApp.create("login");
        assertEquals(LoginCommand.class, outputCommand.getClass());
    }

    @Test
    public void testListBooks() {
        Command outputCommand = BibliotecaApp.create("list books");

        assertEquals(ListBookCommand.class, outputCommand.getClass());
    }

    @Test
    public void testListMovies() {
        Command outputCommand = BibliotecaApp.create("list movies");

        assertEquals(ListMovieCommand.class, outputCommand.getClass());
    }

    @Test
    public void testQuit() {
        Command outputCommand = BibliotecaApp.create("quit");

        assertEquals(QuitCommand.class, outputCommand.getClass());
    }

    @Test
    public void testMenu() {
        Command outputCommand = BibliotecaApp.create("menu");

        assertEquals(MenuCommand.class, outputCommand.getClass());
    }

    @Test
    public void testInvalidCommand() {
        Command outputCommand = BibliotecaApp.create("!!!!");

        assertEquals(InvalidCommand.class, outputCommand.getClass());
    }

    @Test
    public void testCheckoutBook() {
        Command outputCommand = BibliotecaApp.create("checkout book");

        assertEquals(CheckoutBookCommand.class, outputCommand.getClass());
    }


    @Test
    public void testCheckoutMovie() {
        Command outputCommand = BibliotecaApp.create("checkout movie");

        assertEquals(CheckoutMovieCommand.class, outputCommand.getClass());
    }

    @Test
    public void testCheckin() {
        Command outputCommand = BibliotecaApp.create("checkin");

        assertEquals(CheckinBookCommand.class, outputCommand.getClass());
    }

    @Test
    public void testListBorrowers() {
        Command outputCommand = BibliotecaApp.create("list borrowers");

        assertEquals(ListBookBorrowerCommand.class, outputCommand.getClass());
    }

    @Test
    public void testSuccessfulTitleCheck() {
        assertEquals("title1", BibliotecaApp.checkForCheckinOrOut("checkout book title1"));
    }

    @Test
    public void testUnsuccessfulTitleCheck() {
        assertEquals("", BibliotecaApp.checkForCheckinOrOut("checkout"));
    }
}
