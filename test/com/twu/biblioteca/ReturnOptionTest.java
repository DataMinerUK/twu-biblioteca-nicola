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

    private ReturnOption returnOption;
    private LibraryLister library;
    private UserManager userManager;

    @Before
    public void beforeEach(){
        returnOption = new ReturnOption("Return");
    }

    @Test
    public void hasOptionName(){
        assertEquals("Return", returnOption.getOptionName());
    }

    @Test
    public void canReturnToLibrary(){
        library = mock(LibraryLister.class);
        userManager = mock(UserManager.class);
        returnOption.run(library, userManager);
        verify(library, atLeastOnce()).initiateReturn();
    }
}
