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

    private LibraryLister library;
    private ArrayList<LibraryItem> libraryList;
    private Book book1;
    private Book book2;


    @Before
    public void beforeEach(){
        book1 =  setUpBookMock("Lord of the Rings", "J.R.R Tolkein", 1954, false);
        book2 = setUpBookMock("Lord of the Rings", "J.R.R Tolkein", 1969, true);
        libraryList = new ArrayList<LibraryItem>();
        libraryList.addAll(Arrays.asList(book1, book2));
        library = new LibraryLister(libraryList);
    }

    @Test
    public void shouldPrintBooksWhichCanBeCheckedOut(){
        library.callDetails();
        verify(book1, atLeastOnce()).printDetails(System.out);
        verify(book2, never()).printDetails(System.out);
    }

    @Test
    public void canRemoveItemsWhichCanBeCheckedOut(){
        assertEquals("Thank you! Enjoy", library.removeItem("Lord of the Rings", "J.R.R Tolkein", 1954));
        verify(book1, atLeastOnce()).checkOut();
        verify(book2, never()).checkOut();
    }

    @Test
    public void cannotRemoveItemsWhichCannotBeCheckedOut(){
        assertEquals("That item is not available", library.removeItem("Lord of the Rings", "J.R.R Tolkein", 1969));
        verify(book2, never()).checkOut();
    }

    @Test
    public void canReturnItemsWhichCanBeCheckedIn(){
        assertEquals("Thank you for returning", library.returnItem("Lord of the Rings", "J.R.R Tolkein", 1969));
        verify(book2, atLeastOnce()).checkIn();
    }

    @Test
    public void cannotReturnItemsWhichCannotBeCheckedIn(){
        assertEquals("That is not a valid item to return", library.returnItem("Lord of the Rings", "J.R.R Tolkein", 1954));
        verify(book1, never()).checkIn();
    }

    private Book setUpBookMock(String title, String author, int year, boolean bool){
        Book b = mock(Book.class);
        when(b.getTitle()).thenReturn(title);
        when(b.getCreator()).thenReturn(author);
        when(b.getYear()).thenReturn(year);
        when(b.isCheckedOut()).thenReturn(bool);
        return b;
    }

}
