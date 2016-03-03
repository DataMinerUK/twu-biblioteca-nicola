package com.twu.biblioteca;


import java.io.PrintStream;
import java.util.ArrayList;

/**
 * Created by nihughes on 03/03/2016.
 */
public class MainMenu {

    private LibraryLister ll;
    private ArrayList<MenuItem> options;

    public MainMenu(ArrayList<MenuItem> options, LibraryLister ll){
        this.ll = ll;
        this.options = options;
    }


    public void printOptions(PrintStream ps){
        for(MenuItem o: options){
            ps.println(o.getOptionName());
        }
    }
}
