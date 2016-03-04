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

    private MainMenu mainMenu;
    private LibraryLister library;
    private ArrayList<MenuItem>  options;
    private MenuItem menuItem;
    private PrintStream mockPrintStream;

    @Before
    public void beforeEach(){
        library = mock(LibraryLister.class);
        menuItem = mock(ListOption.class);
        when(menuItem.getOptionName()).thenReturn("List Books");
        options = new ArrayList<MenuItem>();
        options.add(menuItem);
        mainMenu = new MainMenu(options, library);
        mockPrintStream = mock(PrintStream.class);
    }

    @Test
    public void canListMenuOptions(){
        mainMenu.printOptions(mockPrintStream);
        verify(mockPrintStream).println("List Books");
    }

    @Test
    public void canRunMenuItems(){
        mainMenu.runMenuOption("LB");
        verify(menuItem, atLeastOnce()).run(library);
    }

    // Did not know how to implement this correctly
//    @Test
//    public void canLetUserKnowIfOptionsInvalid(){
//        mm.runMenuOption("LL", mockPrintStream);
//        verify(mockPrintStream).println("Select a valid option!");
//
//    }

}
