package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
/**
 * Created by nihughes on 02/03/2016.
 */
public class BookTest {

    private Book b;

    @Before
    public void beforeEach(){
        b = new Book("War and Peace", "Leo Tolstoy");
    }

    @Test
    public void bookHasTitle(){
        assertEquals("War and Peace", b.getTitle());
    }

    @Test
    public void bookHasAuthor(){
        assertEquals("Leo Tolstoy", b.getAuthor());
    }
}
