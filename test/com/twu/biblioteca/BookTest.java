package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by nihughes on 02/03/2016.
 */
public class BookTest {

    private Book b;

    @Before
    public void beforeEach(){
        b = new Book("War and Peace", "Leo Tolstoy", 1869);
    }

    @Test
    public void bookHasTitle(){
        assertEquals("War and Peace", b.getTitle());
    }

    @Test
    public void bookHasAuthor(){
        assertEquals("Leo Tolstoy", b.getAuthor());
    }

    @Test
    public void bookHasYear(){
        assertEquals(1869, b.getYear());
    }

    @Test
    public void bookCanPrintDetails(){
        PrintStream mockPrintStream = mock(PrintStream.class);
        b.printDetails(mockPrintStream);
        verify(mockPrintStream).println("War and Peace\tLeo Tolstoy\t1869");
    }
}
