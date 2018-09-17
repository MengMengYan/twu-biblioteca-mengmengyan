package com.twu.biblioteca.navigation;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class QuitCommandTest {
    private Command testee;

    @Before
    public void setUp() {
        this.testee = new QuitCommand();
    }

    @Test
    public void shouldReturnByeMessage() {
        assertEquals("See you again", this.testee.execute(null, null, null));
    }
}
