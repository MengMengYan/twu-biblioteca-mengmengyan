package com.twu.biblioteca.navigation;

import com.twu.biblioteca.bookSystem.Book;
import com.twu.biblioteca.bookSystem.Inventory;
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
        inventory = new Inventory(books);
    }

    @Test
    public void checkoutBookLibrarianView() {
        testee.execute(inventory, "Title1");
        testee = new ListBookCommand();
        assertEquals("Title2\t|\tAuthor2\t|\t1098", this.testee.execute(inventory, null));
    }

    @Test
    public void checkoutSuccessfully() {
        assertEquals("Thank you! Enjoy the book", testee.execute(inventory, "Title1"));
    }

}