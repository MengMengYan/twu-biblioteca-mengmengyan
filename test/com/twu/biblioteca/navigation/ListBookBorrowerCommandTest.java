package com.twu.biblioteca.navigation;

import com.twu.biblioteca.itemSystem.Book;
import com.twu.biblioteca.itemSystem.Inventory;
import com.twu.biblioteca.itemSystem.Item;
import com.twu.biblioteca.roles.Guest;
import com.twu.biblioteca.roles.Librarian;
import com.twu.biblioteca.roles.User;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class ListBookBorrowerCommandTest {

    private Command testee;

    @Before
    public void setUp() {
        this.testee = new ListBookBorrowerCommand();
    }

    @Test
    public void userListBorrowers() {
        assertEquals("Please, log in as a librarian", testee.execute(null, null, new User("111-1111")));
    }


    @Test
    public void guestListBorrowers() {
        assertEquals("Please, log in as a librarian", testee.execute(null, null, new Guest()));
    }


    @Test
    public void librarianListBorrowers() {
        HashMap<String, Item> books = new HashMap<>();
        Book book1 = new Book("Title1", "Author1", 1999);
        book1.checkout(new User("222-2222"));
        Book book2 = new Book("Title2", "Author2", 2000);
        books.put("Title1", book1);
        books.put("Title2", book2);
        Inventory inventory = new Inventory(books, new HashMap<>());
        assertEquals("222-2222 borrowed Title1\t|\tAuthor1\t|\t1999", testee.execute(inventory, null, new Librarian("111-1111")));
    }
}
