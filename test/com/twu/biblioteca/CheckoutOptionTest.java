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

    private CheckoutOption co;
    private LibraryLister ll;

    @Before
    public void beforeEach(){
        co = new CheckoutOption("Check Out");
    }

    @Test
    public void hasOptionName(){
        assertEquals("Check Out", co.getOptionName());
    }

    @Test
    public void canCheckOutFromLibrary(){
        ll = mock(LibraryLister.class);
        co.run(ll);
        verify(ll, atLeastOnce()).removeItem();
    }

}
