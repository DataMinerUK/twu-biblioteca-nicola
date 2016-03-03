package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.io.PrintStream;
import java.util.ArrayList;

/**
 * Created by nihughes on 03/03/2016.
 */
public class MainMenuTest {

    private MainMenu mm;
    private LibraryLister ll;
    private ArrayList<MenuItem>  options;
    private MenuItem mi;
    private PrintStream mockPrintStream;

    @Before
    public void beforeEach(){
        ll = mock(LibraryLister.class);
        mi = mock(ListOption.class);
        when(mi.getOptionName()).thenReturn("List Books");
        options = new ArrayList<MenuItem>();
        options.add(mi);
        mm = new MainMenu(options, ll);
        mockPrintStream = mock(PrintStream.class);
    }

    @Test
    public void canListMenuOptions(){
        mm.printOptions(mockPrintStream);
        verify(mockPrintStream).println("List Books");
    }

    @Test
    public void canRunMenuItems(){
        mm.runMenuOption("LB");
        verify(mi, atLeastOnce()).run(ll);
    }

    // Did not know how to implement this correctly
//    @Test
//    public void canLetUserKnowIfOptionsInvalid(){
//        mm.runMenuOption("LL", mockPrintStream);
//        verify(mockPrintStream).println("Select a valid option!");
//
//    }

}
