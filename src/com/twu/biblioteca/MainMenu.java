package com.twu.biblioteca;


import java.io.PrintStream;

/**
 * Created by nihughes on 03/03/2016.
 */
public class MainMenu {

    private LibraryLister ll;
    private String[] options;

    public MainMenu(String[] options, LibraryLister ll){
        this.ll = ll;
        this.options = options;
    }

    public void printOptions(PrintStream ps){
        for(String o: options){
            ps.println(o);
        }
    }
}
