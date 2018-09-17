package com.twu.biblioteca.navigation;

import com.twu.biblioteca.itemSystem.Book;
import com.twu.biblioteca.itemSystem.Inventory;
import com.twu.biblioteca.itemSystem.Movie;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class ListBookCommandTest {
    private Command testee;
    private Inventory inventory;

    @Before
    public void setUp() {
        this.testee = new ListBookCommand();

        Map<String, Book> books = new HashMap<String, Book>();
        Book book1 = new Book("Title1", "Author1", 2042);
        Book book2 = new Book("Title2", "Author2", 1098);
        books.put("Title1", book1);
        books.put("Title2", book2);

        Map<String, Movie> movies = new HashMap<>();
        inventory = new Inventory(books, movies);
    }

    @Test
    public void shouldListNBooks() {
        assertEquals("Title1\t|\tAuthor1\t|\t2042\n" +
                "Title2\t|\tAuthor2\t|\t1098", this.testee.execute(inventory, null, null));
    }

    @Test
    public void shouldListNoBooks() {
        Map<String, Book> noBooks = new HashMap<>();
        Map<String, Movie> noMovies = new HashMap<>();
        this.inventory = new Inventory(noBooks, noMovies);
        assertEquals("No Book available", this.testee.execute(this.inventory, null, null));
    }
}
