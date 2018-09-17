package com.twu.biblioteca.navigation;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class WelcomeCommandTest {

    private Command testee;

    @Before
    public void setUp() {
        this.testee = new WelcomeCommand();
    }

    @Test
    public void shouldReturnWelcomeMessage() {
        assertEquals("Welcome to Biblioteca", this.testee.execute(null, null));
    }
}
