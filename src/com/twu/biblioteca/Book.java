package com.twu.biblioteca;

/**
 * Created by nihughes on 02/03/2016.
 */
public class Book {
    String title;
    String author;

    public Book(String t, String a){
        title = t;
        author = a;
    }

    public String getTitle(){
        return title;
    }

    public String getAuthor(){
        return author;
    }
}
