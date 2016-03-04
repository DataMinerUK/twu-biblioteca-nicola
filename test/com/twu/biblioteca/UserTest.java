package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by nihughes on 04/03/2016.
 */
public class UserTest {

    private User user;

    @Before
    public void beforeEach(){
        user = new User("Nicola Hughes", "nicola@email.com", "555 123456", "123-4567", "password");
    }

    @Test
    public void userHasName(){
        assertEquals("Nicola Hughes", user.getName());
    }

    @Test
    public void userHasEmail(){
        assertEquals("nicola@email.com", user.getEmail());
    }

    @Test
    public void userHasPhoneNumber(){
        assertEquals("555 123456", user.getPhone());
    }

    @Test
    public void userHasLibraryNumber(){
        assertEquals("123-4567", user.getLibraryNumber());
    }

    @Test
    public void userHasPassword(){
        assertEquals("password", user.getPassword());
    }

    @Test
    public void canBeLoggedIn(){
        user.logIn();
        assertEquals(true, user.isLoggedIn());
    }

    @Test
    public void canBeLoggedOut(){
        user.logOut();
        assertEquals(false, user.isLoggedIn());
    }
}
