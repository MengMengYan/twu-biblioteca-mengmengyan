package com.twu.biblioteca.itemSystem;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BookTest {

    @Test
    public void testGetBookDetails() {
        Book testBook = new Book("And the Mountains Echoed", "Khaled HOSSEINI", 2013);
        assertEquals("And the Mountains Echoed\t|\tKhaled HOSSEINI\t|\t2013", testBook.getDetails());
    }

    @Test
    public void checkoutBookTest() {
        Book testBook = new Book("And the Mountains Echoed", "Khaled HOSSEINI", 2013);
        assertEquals(true, testBook.checkout());
    }

    @Test
    public void testWhoCheckedOutBook() {

    }

    @Test
    public void checkoutWrongBookTest() {
        Book testBook = new Book("And the Mountains Echoed", "Khaled HOSSEINI", 2013);
        testBook.checkout();
        assertEquals(false, testBook.checkout());
    }

    @Test
    public void checkinBookTest() {
        Book testBook = new Book("And the Mountains Echoed", "Khaled HOSSEINI", 2013);
        testBook.checkout();
        assertEquals(true, testBook.checkin());
    }

    @Test
    public void checkinWrongBookTest() {
        Book testBook = new Book("And the Mountains Echoed", "Khaled HOSSEINI", 2013);
        assertEquals(false, testBook.checkin());
    }
}
