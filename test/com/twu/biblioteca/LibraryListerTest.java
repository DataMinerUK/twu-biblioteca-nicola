package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.mockito.Mockito.*;

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
//        when(b1.printDetails(System.out));
        b2 = mock(Book.class);
//        when(b2.printDetails()).thenReturn(true);
        bookList = new ArrayList<Book>();
        bookList.add(b1);
        bookList.add(b2);
    }

    @Test
    public void shouldPrintBooks(){
        ll = new LibraryLister(bookList);
        ll.callDetails();
        verify(b1, atLeastOnce()).printDetails(System.out);
        verify(b2, atLeastOnce()).printDetails(System.out);
    }

}
