package com.twu.biblioteca;

import java.io.PrintStream;

/**
 * Created by nihughes on 04/03/2016.
 */
public abstract class LibraryItem {

    protected String title;
    protected String creator;
    protected int year;
    protected boolean checkedOut = false;
    protected String checkedOutBy;

    protected String getTitle(){
        return title;
    }

    protected String getCreator(){
        return creator;
    }

    protected int getYear() {
        return year;
    }

    protected boolean isCheckedOut(){ return checkedOut; }

    protected String getCheckedOutBy(){
        return checkedOutBy;
    }

    public void setCheckedOutBy(User user){
        checkedOutBy = user.getLibraryNumber();
        checkOut();
    }

    private void checkOut(){
        checkedOut = true;
    }

    public void checkIn(){
        checkedOut = false;
        checkedOutBy = null;
    }

    public abstract void printDetails(PrintStream printStream);



}
