package com.twu.biblioteca;

import java.io.PrintStream;

/**
 * Created by nihughes on 02/03/2016.
 */
public class Book extends LibraryItem {


    public Book(String t, String c, int y){
        super();
        this.title = t;
        this.creator = c;
        this.year = y;
        this.checkedOut = false;
    }

    @Override
    public void printDetails(PrintStream printStream){
        printStream.println(getTitle()+"\t"+getCreator()+"\t"+getYear());
    }

}
