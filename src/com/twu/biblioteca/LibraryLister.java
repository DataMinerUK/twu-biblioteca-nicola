package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by nihughes on 02/03/2016.
 */
public class LibraryLister {
    private ArrayList<Book> bookList;

    public LibraryLister(ArrayList<Book> bookList){
        this.bookList = bookList;
    }

    public void callDetails(){
        for(Book b: bookList){
            if(!b.isCheckedOut()) {
                b.printDetails(System.out);
            }
        }
    }

    public String removeItem(String title, String author, int year){
        for(Book b: bookList){
            if(isSameItem(b, title, author, year) && !b.isCheckedOut()){
                b.checkOut();
                return "Thank you! Enjoy the book";
            }
        }
        return "That book is not available";
    }

    public void initiateCheckOut(){
        String title = getItemTitle();
        String author = getItemAuthor();
        int year = getItemYear();
        System.out.println(removeItem(title, author, year));
    }

    public String returnItem(String title, String author, int year){
        for(Book b: bookList){
            if(isSameItem(b, title, author, year) && b.isCheckedOut()){
                b.checkIn();
                return "Thank you for returning the book";
            }
        }
        return "That is not a valid book to return";
    }

    public void initiateReturn(){
        String title = getItemTitle();
        String author = getItemAuthor();
        int year = getItemYear();
        System.out.println(returnItem(title, author, year));
    }

    private boolean isSameItem(Book b, String title, String author, int year){
        return title.equals(b.getTitle()) && author.equals(b.getAuthor()) && year == b.getYear();
    }

    private String getItemTitle(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the title: ");
        return scanner.nextLine().trim();
    }

    private String getItemAuthor(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the author: ");
        return scanner.nextLine().trim();
    }

    private int getItemYear(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the year: ");
        return scanner.nextInt();
    }

}
