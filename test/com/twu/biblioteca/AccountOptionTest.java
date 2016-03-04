package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by nihughes on 04/03/2016.
 */
public class AccountOptionTest {

    private AccountOption accountOption;
    private LibraryLister library;
    private UserManager userManager;

    @Before
    public void beforeEach(){
        accountOption = new AccountOption("Account");
    }

    @Test
    public void hasOptionName(){
        assertEquals("Account", accountOption.getOptionName());
    }

    @Test
    public void canShowUserDetails(){
        library = mock(LibraryLister.class);
        userManager = mock(UserManager.class);
        accountOption.run(library, userManager);
        verify(userManager, atLeastOnce()).getUserDetails();
    }
}
