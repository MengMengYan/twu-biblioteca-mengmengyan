package com.twu.biblioteca.navigation;

import com.twu.biblioteca.itemSystem.Book;
import com.twu.biblioteca.itemSystem.Inventory;
import com.twu.biblioteca.itemSystem.Movie;
import com.twu.biblioteca.roles.RoleType;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class CheckoutMovieCommandTest {

    private Command testee;
    private Inventory inventory;

    @Before
    public void setUp() {
        this.testee = new CheckoutMovieCommand();

        Map<String, Movie> movies = new HashMap<String, Movie>();
        Movie movie1 = new Movie("Title1", 1000, "Director1");
        Movie movie2 = new Movie("Title2", 2000, "Director2");
        movies.put("Title1", movie1);
        movies.put("Title2", movie2);

        Map<String, Book> books = new HashMap<>();
        inventory = new Inventory(books, movies);
    }

    @Test
    public void checkoutMovieLibrarianView() {
        testee.execute(inventory, "Title1", RoleType.USER);
        testee = new ListMovieCommand();
        assertEquals("Title2\t|\t2000\t|\tDirector2\t|\tunrated", this.testee.execute(inventory, null, RoleType.USER));
    }

    @Test
    public void checkoutSuccessfully() {
        assertEquals("Thank you! Enjoy the movie", testee.execute(inventory, "Title1", RoleType.USER));
    }

    @Test
    public void checkoutUnsuccessfully() {
        assertEquals("That movie is not available", testee.execute(inventory, "Title3", RoleType.USER));
    }

    @Test
    public void checkoutAsGuest() {
        assertEquals("Please, log in!", testee.execute(inventory, "Title1", RoleType.GUEST));
    }
}
