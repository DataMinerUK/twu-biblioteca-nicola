package com.twu.biblioteca;

import org.junit.Test;
import static org.junit.Assert.*;
/**
 * Created by nihughes on 03/03/2016.
 */
public class ListOptionTest {

    private ListOption lo;
    private LibraryLister ll;

    @Test
    public void hasOptionName(){
        lo = new ListOption("List Books");
        assertEquals("List Books", lo.getOptionName());
    }
}
