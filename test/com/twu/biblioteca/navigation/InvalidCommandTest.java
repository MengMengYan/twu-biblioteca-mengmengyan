package com.twu.biblioteca.navigation;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class InvalidCommandTest {

    private Command testee;

    @Before
    public void setUp() {
        this.testee = new InvalidCommand();
    }

    @Test
    public void shouldReturnMenu() {
        assertEquals("Select a valid option!", this.testee.execute(null));
    }
}
