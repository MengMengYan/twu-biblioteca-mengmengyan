package com.twu.biblioteca.navigation;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class QuitCommandTest {
    private Command testee;

    @Before
    public void setUp() throws Exception {
        this.testee = new QuitCommand();
    }

    @Test
    public void shouldExecuteByGivingEmptyString() {
        assertEquals("See you again", this.testee.execute());
    }
}
