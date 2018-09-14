package com.twu.biblioteca.navigation;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MenuCommandTest {
    private Command testee;

    @Before
    public void setUp() throws Exception {
        this.testee = new MenuCommand();
    }

    @Test
    public void shouldExecuteByGivingEmptyString() {
        assertEquals("Menu - Opens menu\tQuit - Quits Biblioteca", this.testee.execute());
    }
}
