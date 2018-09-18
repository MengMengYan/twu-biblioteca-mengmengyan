package com.twu.biblioteca.roles;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UserTest {

    @Test
    public void testUserInformation() {
        assertEquals("Name: Examplename\n" +
                "Mail: example@mail.com\n" +
                "Phone: 010101", new User("777-7777").getUserInformation());
    }
}
