package com.twu.biblioteca;

import java.io.PrintStream;

/**
 * Created by nihughes on 04/03/2016.
 */
public class Movie extends LibraryItem {

    private int rating;

    public Movie(String t, String c, int y, int r){
        super();
        this.title = t;
        this.creator = c;
        this.year = y;
        this.rating = r;
    }


    @Override
    public void printDetails(PrintStream printStream){
        printStream.println(getTitle()+"\t"+getCreator()+"\t"+getYear()+"\t"+getRating());
    }

    private int getRating(){
        return rating;
    }
}
