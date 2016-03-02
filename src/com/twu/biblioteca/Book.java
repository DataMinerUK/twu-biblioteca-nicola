package com.twu.biblioteca;

import java.io.PrintStream;

/**
 * Created by nihughes on 02/03/2016.
 */
public class Book {
    String title;
    String author;
    int year;

    public Book(String t, String a, int y){
        title = t;
        author = a;
        year = y;
    }

    public String getTitle(){
        return title;
    }

    public String getAuthor(){
        return author;
    }

    public int getYear() {
        return year;
    }

    public void printDetails(PrintStream printStream){
        printStream.println(getTitle()+"\t"+getAuthor()+"\t"+getYear());
    }
}
