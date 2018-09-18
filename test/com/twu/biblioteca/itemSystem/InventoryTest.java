package com.twu.biblioteca.itemSystem;

import com.twu.biblioteca.roles.User;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class InventoryTest {
    Inventory inventory;

    @Before
    public void setUp(){
        HashMap<String, Item> books = new HashMap<>();
        Book book1 = new Book("Title1", "Author1", 2042);
        Book book2 = new Book("Title2", "Author2", 1098);
        books.put("Title1", book1);
        books.put("Title2", book2);

        HashMap<String, Item> movies = new HashMap<>();
        Movie movie1 = new Movie("Title1", 19, "Director1");
        Movie movie2 = new Movie("Title2", 444, "Director2");
        movies.put("Title1", movie1);
        movies.put("Title2", movie2);
        inventory = new Inventory(books, movies);
    }

    @Test
    public void testSuccessfulBookCheckout() {
        assertEquals(true, inventory.checkoutBook("Title1", new User("111-1111")));
    }

    @Test
    public void testUnsuccessfulBookCheckout() {
        assertEquals(false, inventory.checkoutBook("Title3", new User("111-1111")));
    }

    @Test
    public void testSuccessfulMovieCheckout() {
        assertEquals(true, inventory.checkoutMovie("Title1", new User("111-1111")));
    }

    @Test
    public void testUnsuccessfulMovieCheckout() {
        assertEquals(false, inventory.checkoutMovie("Title3", new User("111-1111")));
    }

    @Test
    public void testSuccessfulBookReturn() {
        inventory.checkoutBook("Title1", new User("111-1111"));
        assertEquals(true, inventory.checkin("Title1"));
    }

    @Test
    public void testUnsuccessfulBookReturn() {
        assertEquals(false, inventory.checkin("Title"));
    }

}
