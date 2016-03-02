package com.twu.biblioteca;

import org.junit.Test;
import static org.junit.Assert.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * Created by nihughes on 02/03/2016.
 */
public class WelcomeMessageTest {
    private ByteArrayOutputStream outputStream;
    private WelcomeMessage welcome;

    @Test
    public void userSeesWelcomeMessage(){
        outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);
        welcome = new WelcomeMessage();
        welcome.printMessage();
        assertEquals("Welcome to The Bangalore Public Library, A room without books is like a body without a soul ― Marcus Tullius Cicero\n", outputStream.toString());
    }
}
