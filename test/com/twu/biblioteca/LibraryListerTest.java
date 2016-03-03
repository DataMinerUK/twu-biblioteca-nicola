package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

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
        b1 =  setUpBookMock("Lord of the Rings", "J.R.R Tolkein", 1954, false);
        b2 = setUpBookMock("Lord of the Rings", "J.R.R Tolkein", 1969, true);
        bookList = new ArrayList<Book>();
        bookList.addAll(Arrays.asList(b1, b2));
        ll = new LibraryLister(bookList);
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

    @Test
    public void canReturnItemsWhichCanBeCheckedIn(){
        assertEquals("Thank you for returning the book", ll.returnItem("Lord of the Rings", "J.R.R Tolkein", 1969));
        verify(b2, atLeastOnce()).checkIn();
    }

    @Test
    public void cannotReturnItemsWhichCannotBeCheckedIn(){
        assertEquals("That is not a valid book to return", ll.returnItem("Lord of the Rings", "J.R.R Tolkein", 1954));
        verify(b1, never()).checkIn();
    }

    private Book setUpBookMock(String title, String author, int year, boolean bool){
        Book b = mock(Book.class);
        when(b.getTitle()).thenReturn(title);
        when(b.getAuthor()).thenReturn(author);
        when(b.getYear()).thenReturn(year);
        when(b.isCheckedOut()).thenReturn(bool);
        return b;
    }

}
