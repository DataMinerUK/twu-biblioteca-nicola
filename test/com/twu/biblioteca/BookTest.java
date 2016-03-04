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

    private Book book;

    @Before
    public void beforeEach(){
        book = new Book("War and Peace", "Leo Tolstoy", 1869);
    }

    @Test
    public void bookHasTitle(){
        assertEquals("War and Peace", book.getTitle());
    }

    @Test
    public void bookHasAuthor(){
        assertEquals("Leo Tolstoy", book.getAuthor());
    }

    @Test
    public void bookHasYear(){
        assertEquals(1869, book.getYear());
    }

    @Test
    public void bookCanPrintDetails(){
        PrintStream mockPrintStream = mock(PrintStream.class);
        book.printDetails(mockPrintStream);
        verify(mockPrintStream).println("War and Peace\tLeo Tolstoy\t1869");
    }

    @Test
    public void canBeCheckedOut(){
        book.checkOut();
        assertEquals(book.isCheckedOut(), true);
    }

    @Test
    public void canBeReturned(){
        book.checkIn();
        assertEquals(book.isCheckedOut(), false);
    }
}
