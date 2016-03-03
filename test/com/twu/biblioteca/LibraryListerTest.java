package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;
/**
 * Created by nihughes on 02/03/2016.
 */
public class LibraryListerTest {

    private LibraryLister ll;
    private ArrayList<Book> bookList;
    private Book b1;
    private Book b2;


    @Before
    public void beforeEach(){
        b1 =  mock(Book.class);
        b2 = mock(Book.class);
        bookList = new ArrayList<Book>();
        bookList.add(b1);
        bookList.add(b2);
        ll = new LibraryLister(bookList);
        when(b1.getTitle()).thenReturn("Lord of the Rings");
        when(b1.getAuthor()).thenReturn("J.R.R Tolkein");
        when(b1.getYear()).thenReturn(1954);
        when(b1.isCheckedOut()).thenReturn(false);
        when(b2.getTitle()).thenReturn("Lord of the Rings");
        when(b2.getAuthor()).thenReturn("J.R.R Tolkein");
        when(b2.getYear()).thenReturn(1969);
        when(b2.isCheckedOut()).thenReturn(true);
    }

    @Test
    public void shouldPrintBooksWhichCanBeCheckedOut(){
        ll.callDetails();
        verify(b1, atLeastOnce()).printDetails(System.out);
        verify(b2, never()).printDetails(System.out);
    }

    @Test
    public void canRemoveItemsWhichCanBeCheckedOut(){
        assertEquals("Thank you! Enjoy the book", ll.removeItem("Lord of the Rings", "J.R.R Tolkein", 1954));
        verify(b1, atLeastOnce()).checkOut();
        verify(b2, never()).checkOut();
    }

    @Test
    public void cannotRemoveItemsWhichCannotBeCheckedOut(){
        assertEquals("That book is not available", ll.removeItem("Lord of the Rings", "J.R.R Tolkein", 1969));
        verify(b2, never()).checkOut();
    }

}
