package com.twu.biblioteca.roles;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LoginTest {

    @Test
    public void testLibrarianLogin() {
        Login login = new Login();

        assertEquals(RoleType.LIBRARIAN, login.login("111-1111", "xyz"));
    }

    @Test
    public void testUserLogin() {
        Login login = new Login();

        assertEquals(RoleType.USER, login.login("777-7777", "abc"));
    }

    @Test
    public void testWrongUsernameFormat() {
        Login login = new Login();
        assertEquals(RoleType.GUEST, login.login("111", "xyz"));
    }
}
