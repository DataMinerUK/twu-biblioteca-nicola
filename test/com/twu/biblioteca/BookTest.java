package com.twu.biblioteca;

import org.junit.Test;
import static org.junit.Assert.*;
/**
 * Created by nihughes on 02/03/2016.
 */
public class BookTest {

    private Book b;

    @Test
    public void bookHasTitle(){
        b = new Book("War and Peace");
        assertEquals("War and Peace", b.getTitle());
    }
}
