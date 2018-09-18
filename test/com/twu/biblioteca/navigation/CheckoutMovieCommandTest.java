package com.twu.biblioteca.navigation;

import com.twu.biblioteca.itemSystem.Inventory;
import com.twu.biblioteca.itemSystem.Item;
import com.twu.biblioteca.itemSystem.Movie;
import com.twu.biblioteca.roles.Guest;
import com.twu.biblioteca.roles.User;
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

        Map<String, Item> movies = new HashMap<>();
        Movie movie1 = new Movie("Title1", 1000, "Director1");
        Movie movie2 = new Movie("Title2", 2000, "Director2");
        movies.put("Title1", movie1);
        movies.put("Title2", movie2);

        Map<String, Item> books = new HashMap<>();
        inventory = new Inventory(books, movies);
    }

    @Test
    public void checkoutMovieLibrarianView() {
        testee.execute(inventory, "Title1", new User("111-1111"));
        testee = new ListMovieCommand();
        assertEquals("Title2\t|\t2000\t|\tDirector2\t|\tunrated", this.testee.execute(inventory, null, new User("111-1111")));
    }

    @Test
    public void checkoutSuccessfully() {
        assertEquals("Thank you! Enjoy the movie", testee.execute(inventory, "Title1", new User("111-1111")));
    }

    @Test
    public void checkoutUnsuccessfully() {
        assertEquals("That movie is not available", testee.execute(inventory, "Title3", new User("111-1111")));
    }

    @Test
    public void checkoutAsGuest() {
        assertEquals("Please, log in!", testee.execute(inventory, "Title1", new Guest()));
    }
}
