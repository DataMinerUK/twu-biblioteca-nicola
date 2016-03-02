package com.twu.biblioteca;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * Created by nihughes on 02/03/2016.
 */
public class WelcomeMessageTest {
    private WelcomeMessage welcome;

    @Test
    public void userSeesWelcomeMessage(){
        String welcomeMessage = "Welcome to The Bangalore Public Library, A room without books is like a body without a soul ― Marcus Tullius Cicero";
        PrintStream mockPrintStream = mock(PrintStream.class);

        welcome = new WelcomeMessage(mockPrintStream);

        welcome.printMessage();

        verify(mockPrintStream).println(welcomeMessage);
    }
}

//        when(mockPrintStream.checkError()).thenReturn(true);
