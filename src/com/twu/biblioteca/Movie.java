package com.twu.biblioteca;

import java.io.PrintStream;

/**
 * Created by nihughes on 04/03/2016.
 */
public class Movie extends LibraryItem {

    private String director;
    private int rating;

    public Movie(String t, String d, int y, int r){
        super();
        this.title = t;
        this.director = d;
        this.year = y;
        this.rating = r;
        this.checkedOut = false;
    }

    public String getDirector(){
        return director;
    }

    @Override
    public void printDetails(PrintStream printStream){
        printStream.println(getTitle()+"\t"+getDirector()+"\t"+getYear()+"\t"+getRating());
    }

    private int getRating(){
        return rating;
    }
}
