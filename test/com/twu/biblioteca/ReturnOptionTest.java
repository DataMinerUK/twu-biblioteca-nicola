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
public class ReturnOptionTest {

    private ReturnOption ro;
    private LibraryLister ll;

    @Before
    public void beforeEach(){
        ro = new ReturnOption("Return");
    }

    @Test
    public void hasOptionName(){
        assertEquals("Return", ro.getOptionName());
    }

    @Test
    public void canReturnToLibrary(){
        ll = mock(LibraryLister.class);
        ro.run(ll);
        verify(ll, atLeastOnce()).initiateReturn();
    }
}
