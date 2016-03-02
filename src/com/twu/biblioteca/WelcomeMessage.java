package com.twu.biblioteca;

import java.io.PrintStream;

/**
 * Created by nihughes on 02/03/2016.
 */
public class WelcomeMessage {
    private PrintStream printStream;

    public WelcomeMessage(PrintStream printStream) {
        this.printStream = printStream;
    }

    public void printMessage(){
        printStream.println("Welcome to The Bangalore Public Library, A room without books is like a body without a soul ― Marcus Tullius Cicero");
    }
}
