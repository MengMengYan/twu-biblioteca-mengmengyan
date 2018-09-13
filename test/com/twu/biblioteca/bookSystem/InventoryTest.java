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
    public void testInventory() {
        assertEquals("Title1\t|\tAuthor1\t|\t2042\nTitle2\t|\tAuthor2\t|\t1098", inventory.getBookList());
    }

    @Test
    public void testCheckoutLibrarianPerspective() {
        inventory.checkout("Title1");
        assertEquals("Title2\t|\tAuthor2\t|\t1098", inventory.getBookList());
    }

    @Test
    public void testSuccessfulCheckout() {
        assertEquals("Thank you! Enjoy the book", inventory.checkout("Title1"));
    }

    @Test
    public void testUnsuccessfulCheckout() {
        assertEquals("That book is not available", inventory.checkout("Title3"));
    }

    @Test
    public void testCheckinLibrarianPerspectivet() {
        inventory.checkout("Title1");
        inventory.checkin("Title1");
        assertEquals("Title1\t|\tAuthor1\t|\t2042\nTitle2\t|\tAuthor2\t|\t1098", inventory.getBookList());
    }

    @Test
    public void testSuccessfulReturn() {
        inventory.checkout("Title1");
        assertEquals("Thank you for returning the book", inventory.checkin("Title1"));
    }

}
