package com.twu.biblioteca.navigation;

import com.twu.biblioteca.roles.RoleType;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LoginCommandTest {

    private Command testee;

    @Before
    public void setUp() {
        this.testee = new LoginCommand();
    }

    @Test
    public void userLogin() {
        assertEquals("You are now logged in as a user", testee.execute(null, null, RoleType.USER));
    }


    @Test
    public void guestLogin() {
        assertEquals("You did not log in successfully", testee.execute(null, null, RoleType.GUEST));
    }


    @Test
    public void librarianLogin() {
        assertEquals("You are now logged in as a librarian", testee.execute(null, null, RoleType.LIBRARIAN));
    }
}
