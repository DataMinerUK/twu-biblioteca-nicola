package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;
import java.io.PrintStream;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.*;
/**
 * Created by nihughes on 02/03/2016.
 */
public class BookTest {

    private Book book;
    private User user;

    @Before
    public void beforeEach(){
        book = new Book("War and Peace", "Leo Tolstoy", 1869);
        user = mock(User.class);
        when(user.getLibraryNumber()).thenReturn("123-4567");
    }

    @Test
    public void bookHasTitle(){
        assertEquals("War and Peace", book.getTitle());
    }

    @Test
    public void bookHasCreator(){
        assertEquals("Leo Tolstoy", book.getCreator());
    }

    @Test
    public void bookHasYear(){
        assertEquals(1869, book.getYear());
    }

    @Test
    public void isInitiallyNotCheckedout(){
        assertEquals(false, book.isCheckedOut());
    }


    @Test
    public void initalCheckedoutByIsNull(){
        assertEquals(null, book.getCheckedOutBy());
    }

    @Test
    public void bookCanPrintDetails(){
        PrintStream mockPrintStream = mock(PrintStream.class);
        book.printDetails(mockPrintStream);
        verify(mockPrintStream).println("War and Peace\tLeo Tolstoy\t1869");
    }

    @Test
    public void canBeCheckedOutByUser(){
        book.setCheckedOutBy(user);
        assertEquals(book.isCheckedOut(), true);
        assertEquals(book.getCheckedOutBy(), "123-4567");
    }

    @Test
    public void canBeReturned(){
        book.checkIn();
        assertEquals(book.isCheckedOut(), false);
        assertEquals(book.getCheckedOutBy(), null);
    }
}
