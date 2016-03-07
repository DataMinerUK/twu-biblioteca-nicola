package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by nihughes on 04/03/2016.
 */
public class MovieTest {
    private Movie movie;
    private User user;

    @Before
    public void beforeEach(){
        movie = new Movie("City of God", "Fernando Meirelles", 2003, 5);
        user = mock(User.class);
        when(user.getLibraryNumber()).thenReturn("123-4567");
    }

    @Test
    public void movieHasTitle(){
        assertEquals("City of God", movie.getTitle());
    }

    @Test
    public void movieHasCreator(){
        assertEquals("Fernando Meirelles", movie.getCreator());
    }

    @Test
    public void movieHasYear(){
        assertEquals(2003, movie.getYear());
    }

    @Test
    public void isInitiallyNotCheckedout(){
        assertEquals(false, movie.isCheckedOut());
    }


    @Test
    public void initalCheckedoutByIsNull(){
        assertEquals(null, movie.getCheckedOutBy());
    }

    @Test
    public void movieCanPrintDetails(){
        PrintStream mockPrintStream = mock(PrintStream.class);
        movie.printDetails(mockPrintStream);
        verify(mockPrintStream).println("City of God\tFernando Meirelles\t2003\t5");
    }

    @Test
    public void canBeCheckedOut(){
        movie.setCheckedOutBy(user);
        assertEquals(movie.isCheckedOut(), true);
        assertEquals(movie.getCheckedOutBy(), "123-4567");
    }

    @Test
    public void canBeReturned(){
        movie.checkIn();
        assertEquals(movie.isCheckedOut(), false);
        assertEquals(movie.getCheckedOutBy(), null);
    }
}
