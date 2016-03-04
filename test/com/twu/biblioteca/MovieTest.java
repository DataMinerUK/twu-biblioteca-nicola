package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by nihughes on 04/03/2016.
 */
public class MovieTest {
    private Movie movie;

    @Before
    public void beforeEach(){
        movie = new Movie("City of God", "Fernando Meirelles", 2003, 5);
    }

    @Test
    public void movieHasTitle(){
        assertEquals("City of God", movie.getTitle());
    }

    @Test
    public void movieHasDirector(){
        assertEquals("Fernando Meirelles", movie.getDirector());
    }

    @Test
    public void movieHasYear(){
        assertEquals(2003, movie.getYear());
    }

    @Test
    public void movieCanPrintDetails(){
        PrintStream mockPrintStream = mock(PrintStream.class);
        movie.printDetails(mockPrintStream);
        verify(mockPrintStream).println("City of God\tFernando Meirelles\t2003\t5");
    }

    @Test
    public void canBeCheckedOut(){
        movie.checkOut();
        assertEquals(movie.isCheckedOut(), true);
    }

    @Test
    public void canBeReturned(){
        movie.checkIn();
        assertEquals(movie.isCheckedOut(), false);
    }
}
