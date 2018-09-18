package com.twu.biblioteca.navigation;

import com.twu.biblioteca.roles.Guest;
import com.twu.biblioteca.roles.Librarian;
import com.twu.biblioteca.roles.User;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UserInformationCommandTest {

    private Command testee;

    @Before
    public void setUp() {
        this.testee = new UserInformationCommand();
    }

    @Test
    public void userInformation() {
        assertEquals("Name: Examplename\n" +
                "Mail: example@mail.com\n" +
                "Phone: 010101", testee.execute(null, null, new User("777-7777")));
    }


    @Test
    public void guestInformation() {
        assertEquals("Public guest accounts do not have information stored", testee.execute(null, null, new Guest()));
    }


    @Test
    public void librarianInformation() {
        assertEquals("You may log in as a guest", testee.execute(null, null, new Librarian("111-1111")));
    }
}
