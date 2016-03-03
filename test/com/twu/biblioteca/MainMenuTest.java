package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.io.PrintStream;
import java.util.ArrayList;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by nihughes on 03/03/2016.
 */
public class MainMenuTest {

    private MainMenu mm;
    private ArrayList<Book> bookList;
    private Book b1;
    private Book b2;
    private LibraryLister ll;
    private String[] options;

    @Before
    public void beforeEach(){
        b1 =  mock(Book.class);
        b2 = mock(Book.class);
        bookList = new ArrayList<Book>();
        bookList.add(b1);
        bookList.add(b2);
        ll = mock(LibraryLister.class);
    }

    @Test
    public void canListMenuOptions(){
        options = new String[] {"List Books"};
        mm = new MainMenu(options, ll);
        PrintStream mockPrintStream = mock(PrintStream.class);
        mm.printOptions(mockPrintStream);
        verify(mockPrintStream).println("List Books");
    }

}
