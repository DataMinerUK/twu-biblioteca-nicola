package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * Created by nihughes on 03/03/2016.
 */
public class ListOptionTest {

    private ListOption listOption;
    private LibraryLister library;
    private UserManager userManager;

    @Before
    public void beforeEach(){
        listOption = new ListOption("List Books");
    }

    @Test
    public void hasOptionName(){
        assertEquals("List Books", listOption.getOptionName());
    }

    @Test
    public void canCalibraryDetailsOfLibraryLister(){
        library = mock(LibraryLister.class);
        userManager = mock(UserManager.class);
        listOption.run(library, userManager);
        verify(library, atLeastOnce()).callDetails();
    }
}
