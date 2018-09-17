package com.twu.biblioteca.navigation;

import com.twu.biblioteca.itemSystem.Book;
import com.twu.biblioteca.itemSystem.Inventory;
import com.twu.biblioteca.itemSystem.Movie;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class ListMovieCommandTest {
    private Command testee;
    private Inventory inventory;

    @Before
    public void setUp() {
        this.testee = new ListMovieCommand();

        Map<String, Book> books = new HashMap<>();
        Map<String, Movie> movies = new HashMap<>();
        Movie movie1 = new Movie("Title1", 1111, "Director1");
        Movie movie2 = new Movie("Title2", 2011, "Director2", 10);
        movies.put("Title1", movie1);
        movies.put("Title2", movie2);
        inventory = new Inventory(books, movies);
    }

    @Test
    public void shouldListNMovies() {
        assertEquals("Title1\t|\t1111\t|\tDirector1\t|\tunrated\n" +
                "Title2\t|\t2011\t|\tDirector2\t|\t10", this.testee.execute(inventory, null, null));
    }

    @Test
    public void shouldListNoBooks() {
        Map<String, Book> noBooks = new HashMap<>();
        Map<String, Movie> noMovies = new HashMap<>();
        this.inventory = new Inventory(noBooks, noMovies);
        assertEquals("No Movie available", this.testee.execute(this.inventory, null, null));
    }
}
