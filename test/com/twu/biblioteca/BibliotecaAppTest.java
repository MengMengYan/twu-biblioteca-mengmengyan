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
    public void testUserFlow() {
        Thread threadStartingMain = new Thread() {
            public void run() {
                BibliotecaApp.main(new String[]{});
            }
        };

        ByteArrayInputStream in = new ByteArrayInputStream("Quit".getBytes());
        System.setIn(in);

        threadStartingMain.start();

        try {
            threadStartingMain.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        assertEquals("Welcome to Biblioteca\nSee you again", outContent.toString().trim());
    }
}
