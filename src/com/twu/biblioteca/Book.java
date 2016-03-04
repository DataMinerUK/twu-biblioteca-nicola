package com.twu.biblioteca;

import java.io.PrintStream;

/**
 * Created by nihughes on 02/03/2016.
 */
public class Book extends LibraryItem{

    private String author;

    public Book(String t, String a, int y){
        super();
        this.title = t;
        this.author = a;
        this.year = y;
        this.checkedOut = false;
    }

    public String getAuthor(){
        return author;
    }

    @Override
    public void printDetails(PrintStream printStream){
        printStream.println(getTitle()+"\t"+getAuthor()+"\t"+getYear());
    }
    
}
