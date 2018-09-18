package com.twu.biblioteca.itemSystem;

import com.twu.biblioteca.roles.User;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BookTest {
    private Book testBook;

    @Before
    public void setup() {
        testBook = new Book("And the Mountains Echoed", "Khaled HOSSEINI", 2013);
    }

    @Test
    public void testGetBookDetails() {
        assertEquals("And the Mountains Echoed\t|\tKhaled HOSSEINI\t|\t2013", testBook.getDetails());
    }

    @Test
    public void checkoutBookTest() {
        assertEquals(true, testBook.checkout(new User("111-1111")));
    }

    @Test
    public void testWhoCheckedOutBook() {
        testBook.checkout(new User("111-1111"));
        assertEquals("111-1111", testBook.getBorrower());
    }

    @Test
    public void checkoutWrongBookTest() {
        testBook.checkout(new User("111-1111"));
        assertEquals(false, testBook.checkout(new User("111-1111")));
    }

    @Test
    public void checkinBookTest() {
        testBook.checkout(new User("111-1111"));
        assertEquals(true, testBook.checkin());
    }

    @Test
    public void checkinWrongBookTest() {
        assertEquals(false, testBook.checkin());
    }
}
