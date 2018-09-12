package com.twu.biblioteca.bookSystem;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BookTest {

    @Test
    public void testGetBookDetails() {
        Book testBook = new Book("And the Mountains Echoed", "Khaled HOSSEINI", 2013);
        assertEquals("And the Mountains Echoed\t|\tKhaled HOSSEINI\t|\t2013", testBook.getDetails());
    }
}
