package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.*;

/**
 * Created by nihughes on 03/03/2016.
 */
public class CheckoutOptionTest {

    private CheckoutOption checkout;
    private LibraryLister library;
    private UserManager userManager;
    private User user;

    @Before
    public void beforeEach(){
        checkout = new CheckoutOption("Check Out");
    }

    @Test
    public void hasOptionName(){
        assertEquals("Check Out", checkout.getOptionName());
    }

    @Test
    public void canCheckOutFromLibrary(){
        user = mock(User.class);
        library = mock(LibraryLister.class);
        userManager = mock(UserManager.class);
        when(userManager.getLoggedInUser()).thenReturn(user);
        checkout.run(library, userManager);
        verify(library, atLeastOnce()).initiateCheckOut(user);
    }

}
