package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by nihughes on 03/03/2016.
 */
public class QuitOptionTest {

    private QuitOption q;
    private LibraryLister ll;

    @Test
    public void hasOptionName(){
        q= new QuitOption("Quit");
        assertEquals("Quit", q.getOptionName());
    }

}
