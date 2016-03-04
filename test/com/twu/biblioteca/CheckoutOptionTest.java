package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by nihughes on 03/03/2016.
 */
public class CheckoutOptionTest {

    private CheckoutOption checkout;
    private LibraryLister library;

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
        library = mock(LibraryLister.class);
        checkout.run(library);
        verify(library, atLeastOnce()).initiateCheckOut();
    }

}
