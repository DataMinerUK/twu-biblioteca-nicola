package com.twu.biblioteca;

import java.io.PrintStream;

/**
 * Created by nihughes on 04/03/2016.
 */
public abstract class LibraryItem {

    public String title;
    protected int year;
    protected boolean checkedOut;

    public String getTitle(){
        return title;
    }

    public int getYear() {
        return year;
    }

    public boolean isCheckedOut(){ return checkedOut; }

    public void checkOut(){
        checkedOut = true;
    }

    public void checkIn(){
        checkedOut = false;
    }

    public abstract void printDetails(PrintStream printStream);



}
