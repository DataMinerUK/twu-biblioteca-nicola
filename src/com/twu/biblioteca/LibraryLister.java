package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by nihughes on 02/03/2016.
 */
public class LibraryLister {
    private ArrayList<LibraryItem> libraryList;
    private ArrayList<LibraryItem> userItems;

    public LibraryLister(ArrayList<LibraryItem> libraryList){
        this.libraryList = libraryList;
    }

    public ArrayList<LibraryItem> getUserItems(User user){
        userItems = new ArrayList<LibraryItem>();
        for(LibraryItem libraryItem: libraryList){
            if(user.getLibraryNumber().equals(libraryItem.getCheckedOutBy())){
                userItems.add(libraryItem);
            }
        }
        return userItems;
    }

    public void callDetails(){
        for(LibraryItem l: libraryList){
            if(!l.isCheckedOut()) {
                l.printDetails(System.out);
            }
        }
    }

    public String removeItem(String title, String creator, int year, User user){
        for(LibraryItem l: libraryList){
            if(isSameItem(l, title, creator, year) && !l.isCheckedOut()){
                l.setCheckedOutBy(user);
                return "Thank you! Enjoy";
            }
        }
        return "That item is not available";
    }

    public void initiateCheckOut(User user){
        String title = getItemTitle();
        String creator = getItemCreator();
        int year = getItemYear();
        System.out.println(removeItem(title, creator, year, user));
    }

    public String returnItem(String title, String creator, int year){
        for(LibraryItem l: libraryList){
            if(isSameItem(l, title, creator, year) && l.isCheckedOut()){
                l.checkIn();
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
