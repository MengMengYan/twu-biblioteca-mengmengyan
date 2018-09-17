package com.twu.biblioteca.itemSystem;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MovieTest {

    @Test
    public void testGetDetails() {
        Movie testMovie = new Movie("Title1", 1999, "Director1", 2);
        assertEquals("Title1\t|\t1999\t|\tDirector1\t|\t2", testMovie.getDetails());
    }

    @Test
    public void testGetDetailsForUnrated() {
        Movie testMovie = new Movie("Title1", 1999, "Director1");
        assertEquals("Title1\t|\t1999\t|\tDirector1\t|\tunrated", testMovie.getDetails());
    }

    @Test
    public void checkoutMovieTest() {
        Movie testMovie = new Movie("Title1", 1111, "Director1");
        assertEquals(true, testMovie.checkout());
    }

    @Test
    public void checkoutWrongBookTest() {
        Movie testMovie = new Movie("Title1", 1111, "Director1");
        testMovie.checkout();
        assertEquals(false, testMovie.checkout());
    }

    @Test
    public void checkinBookTest() {
        Movie testMovie = new Movie("Title1", 1111, "Director1");
        assertEquals(false, testMovie.checkin());
    }

    @Test
    public void checkinWrongBookTest() {
        Movie testMovie = new Movie("Title1", 1111, "Director1");
        testMovie.checkout();
        assertEquals(true, testMovie.checkin());
    }
}
