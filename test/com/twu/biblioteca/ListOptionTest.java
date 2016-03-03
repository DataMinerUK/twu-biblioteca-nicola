package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * Created by nihughes on 03/03/2016.
 */
public class ListOptionTest {

    private ListOption lo;
    private LibraryLister ll;

    @Before
    public void beforeEach(){
        lo = new ListOption("List Books");
    }

    @Test
    public void hasOptionName(){
        assertEquals("List Books", lo.getOptionName());
    }

    @Test
    public void canCallDetailsOfLibraryLister(){
        ll = mock(LibraryLister.class);
        lo.run(ll);
        verify(ll, atLeastOnce()).callDetails();
    }
}
