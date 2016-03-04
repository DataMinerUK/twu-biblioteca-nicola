package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
/**
 * Created by nihughes on 04/03/2016.
 */
public class UserManagerTest {

    private UserManager userManager;
    private ArrayList<User> users;
    private User u1;
    private User u2;

    @Before
    public void beforeEach(){
        u1 = setUpMockUser("Nicola", "nicola@email.com", "555 123456", "123-4567", "password");
        u2 = setUpMockUser("Rose", "rose@email.com", "555 555555", "555-5555", "password5");
        users = new ArrayList<User>();
        users.addAll(Arrays.asList(u1, u2));
        userManager = new UserManager(users);
    }

    @Test
    public void canLogInUser(){
        userManager.canUserLogIn("123-4567", "password");
        verify(u1, atLeastOnce()).logIn();
        verify(u2, never()).logIn();
    }

    @Test
    public void canLogOutUser(){
        when(u1.isLoggedIn()).thenReturn(true);
        userManager.logOutUser();
        verify(u1, atLeastOnce()).logOut();
        verify(u2, never()).logOut();
    }

    @Test
    public void canShowDetailsOfUser(){
        when(u1.isLoggedIn()).thenReturn(true);
        assertEquals("Name: Nicola\nEmail: nicola@email.com\nPhone number: 555 123456", userManager.getUserDetails());
    }

    private User setUpMockUser(String name, String email, String phone, String libraryNumber, String password){
        User u = mock(User.class);
        when(u.getName()).thenReturn(name);
        when(u.getEmail()).thenReturn(email);
        when(u.getPhone()).thenReturn(phone);
        when(u.getLibraryNumber()).thenReturn(libraryNumber);
        when(u.getPassword()).thenReturn(password);
        return u;
    }


}
