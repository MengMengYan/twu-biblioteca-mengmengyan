package com.twu.biblioteca.bookSystem;

import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class InventoryTest {

    @Test
    public void testInventory() {
        HashMap<String,Book> books = new HashMap<String, Book>();
        Book book1 = new Book("Title1", "Author1", 2042);
        Book book2 = new Book("Title2", "Author2", 1098);
        books.put("Title1", book1);
        books.put("Title2", book2);
        Inventory inventory = new Inventory(books);

        assertEquals("Title1\t|\tAuthor1\t|\t2042\nTitle2\t|\tAuthor2\t|\t1098", inventory.getBookList());
    }
}
