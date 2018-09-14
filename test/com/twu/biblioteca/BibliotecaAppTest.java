package com.twu.biblioteca;


import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class BibliotecaAppTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void testListBooks() throws InterruptedException {
        Thread threadStartingMain = new Thread(() -> BibliotecaApp.main(new String[]{}));

        ByteArrayInputStream in = new ByteArrayInputStream("List Books\n".getBytes());
        System.setIn(in);

        threadStartingMain.start();
        Thread.sleep(100);
        assertEquals("Welcome to Biblioteca\n" +
                "Menu - Opens menu\tList Books - Lists all available books\tQuit - Quits Biblioteca\n" +
                "Title1\t|\tAuthor1\t|\t2042\nTitle2\t|\tAuthor2\t|\t1098", outContent.toString().trim());
    }

    @Test
    public void testQuit() throws InterruptedException {
        Thread threadStartingMain = new Thread(() -> BibliotecaApp.main(new String[]{}));

        ByteArrayInputStream in = new ByteArrayInputStream("Quit".getBytes());
        System.setIn(in);

        threadStartingMain.start();
        Thread.sleep(100);
        assertEquals("Welcome to Biblioteca\n" +
                "Menu - Opens menu\tList Books - Lists all available books\tQuit - Quits Biblioteca\n" +
                "See you again", outContent.toString().trim());
    }
}
