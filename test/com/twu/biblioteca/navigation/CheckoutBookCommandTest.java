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

public class CheckoutBookCommandTest {
    private Command testee;
    private Inventory inventory;

    @Before
    public void setUp() {
        this.testee = new CheckoutBookCommand();

        Map<String, Book> books = new HashMap<String, Book>();
        Book book1 = new Book("Title1", "Author1", 2042);
        Book book2 = new Book("Title2", "Author2", 1098);
        books.put("Title1", book1);
        books.put("Title2", book2);

        Map<String, Movie> movies = new HashMap<>();
        inventory = new Inventory(books, movies);
    }

    @Test
    public void checkoutBookLibrarianView() {
        testee.execute(inventory, "Title1", RoleType.USER);
        testee = new ListBookCommand();
        assertEquals("Title2\t|\tAuthor2\t|\t1098", this.testee.execute(inventory, null, RoleType.GUEST));
    }

    @Test
    public void checkoutSuccessfully() {
        assertEquals("Thank you! Enjoy the book", testee.execute(inventory, "Title1", RoleType.USER));
    }

    @Test
    public void checkoutUnsuccessfully() {
        assertEquals("That book is not available", testee.execute(inventory, "Title3", RoleType.USER));
    }

    @Test
    public void checkoutAsGuest() {
        assertEquals("Please, log in!", testee.execute(inventory, "Title1", RoleType.GUEST));
    }
}
