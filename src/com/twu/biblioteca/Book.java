package com.twu.biblioteca;

import java.io.PrintStream;

/**
 * Created by nihughes on 02/03/2016.
 */
public class Book {
    String title;
    String author;
    int year;
    boolean checkedOut;

    public Book(String t, String a, int y){
        this.title = t;
        this.author = a;
        this.year = y;
        this.checkedOut = false;
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

    public boolean isCheckedOut(){ return checkedOut; }

    public void printDetails(PrintStream printStream){
        printStream.println(getTitle()+"\t"+getAuthor()+"\t"+getYear());
    }

    public void checkOut(){
        checkedOut = true;
    }

    public void checkIn(){
        checkedOut = false;
    }
}
