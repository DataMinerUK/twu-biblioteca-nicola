package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by nihughes on 02/03/2016.
 */
public class LibraryLister {
    private ArrayList<LibraryItem> libraryList;

    public LibraryLister(ArrayList<LibraryItem> libraryList){
        this.libraryList = libraryList;
    }

    public void callDetails(){
        for(LibraryItem l: libraryList){
            if(!l.isCheckedOut()) {
                l.printDetails(System.out);
            }
        }
    }

    public String removeItem(String title, String creator, int year){
        for(LibraryItem l: libraryList){
            if(isSameItem(l, title, creator, year) && !l.isCheckedOut()){
                l.checkOut();
                return "Thank you! Enjoy";
            }
        }
        return "That item is not available";
    }

    public void initiateCheckOut(){
        String title = getItemTitle();
        String creator = getItemCreator();
        int year = getItemYear();
        System.out.println(removeItem(title, creator, year));
    }

    public String returnItem(String title, String creator, int year){
        for(LibraryItem b: libraryList){
            if(isSameItem(b, title, creator, year) && b.isCheckedOut()){
                b.checkIn();
                return "Thank you for returning";
            }
        }
        return "That is not a valid item to return";
    }

    public void initiateReturn(){
        String title = getItemTitle();
        String creator = getItemCreator();
        int year = getItemYear();
        System.out.println(returnItem(title, creator, year));
    }

    private boolean isSameItem(LibraryItem l, String title, String creator, int year){
        return title.equals(l.getTitle()) && creator.equals(l.getCreator()) && year == l.getYear();
    }

    private String getItemTitle(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the title: ");
        return scanner.nextLine().trim();
    }

    private String getItemCreator(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the author/director: ");
        return scanner.nextLine().trim();
    }

    private int getItemYear(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the year: ");
        return scanner.nextInt();
    }

}
