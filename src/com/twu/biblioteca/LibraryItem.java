package com.twu.biblioteca;

import java.io.PrintStream;

/**
 * Created by nihughes on 04/03/2016.
 */
public abstract class LibraryItem {

    protected String title;
    protected int year;
    protected boolean checkedOut;

    protected String getTitle(){
        return title;
    }

    protected int getYear() {
        return year;
    }

    protected boolean isCheckedOut(){ return checkedOut; }

    public void checkOut(){
        checkedOut = true;
    }

    public void checkIn(){
        checkedOut = false;
    }

    public abstract void printDetails(PrintStream printStream);



}
