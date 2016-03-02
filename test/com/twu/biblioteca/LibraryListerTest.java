package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.PrintStream;
import java.util.ArrayList;

/**
 * Created by nihughes on 02/03/2016.
 */
public class LibraryListerTest {

    private LibraryLister bl;
    private ArrayList<Book> bookList;

    @Before
    public void beforeEach(){
        Book b1 = mock(Book.class);
        when(b1.getTitle()).thenReturn("Lord of the Rings");
        Book b2 = mock(Book.class);
        when(b2.getTitle()).thenReturn("Pride and Prejudice");
        Book b3 = mock(Book.class);
        when(b3.getTitle()).thenReturn("Crime and Punishment");
        Book b4 = mock(Book.class);
        when(b4.getTitle()).thenReturn("Les Miserable");
        bookList = new ArrayList<Book>();
        bookList.add(b1);
        bookList.add(b2);
        bookList.add(b3);
        bookList.add(b4);
    }

    @Test
    public void shouldPrintBooks(){
        bl = new LibraryLister(ArrayList<Book> bookList);
        PrintStream mockPrintStream = mock(PrintStream.class);

    }

}
