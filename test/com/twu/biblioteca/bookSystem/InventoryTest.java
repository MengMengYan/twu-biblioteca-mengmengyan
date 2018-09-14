package com.twu.biblioteca.bookSystem;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class InventoryTest {
    Inventory inventory;

    @Before
    public void setUp(){
        HashMap<String,Book> books = new HashMap<String, Book>();
        Book book1 = new Book("Title1", "Author1", 2042);
        Book book2 = new Book("Title2", "Author2", 1098);
        books.put("Title1", book1);
        books.put("Title2", book2);
        inventory = new Inventory(books);
    }

    @Test
    public void testSuccessfulCheckout() {
        assertEquals(true, inventory.checkout("Title1"));
    }

    @Test
    public void testUnsuccessfulCheckout() {
        assertEquals(false, inventory.checkout("Title3"));
    }

    @Test
    public void testSuccessfulReturn() {
        inventory.checkout("Title1");
        assertEquals(true, inventory.checkin("Title1"));
    }

    @Test
    public void testUnsuccessfulReturn() {
        assertEquals(false, inventory.checkin("Title"));
    }

}
