package com.twu.biblioteca.navigation;

import com.twu.biblioteca.itemSystem.Book;
import com.twu.biblioteca.itemSystem.Inventory;
import com.twu.biblioteca.itemSystem.Movie;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class CheckinBookCommandTest {
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

        testee.execute(inventory, "Title1");
        testee = new CheckinBookCommand();
    }

    @Test
    public void checkinBookLibrarianView() {
        testee.execute(inventory, "Title1");
        testee = new ListBookCommand();
        assertEquals("Title1\t|\tAuthor1\t|\t2042\n" +
                "Title2\t|\tAuthor2\t|\t1098", this.testee.execute(inventory, null));
    }

    @Test
    public void checkinSuccessfully() {
        assertEquals("Thank you for returning the book", testee.execute(inventory, "Title1"));
    }

    @Test
    public void checkinUnsuccessfully() {
        assertEquals("That is not a valid book to return", testee.execute(inventory, "Title3"));
    }
}
