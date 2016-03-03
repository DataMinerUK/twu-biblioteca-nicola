package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class BibliotecaApp {

    private ArrayList<MenuItem> options;
    private ArrayList<Book> bookList;

    public static void main(String[] args) {
        BibliotecaApp bibliotec = new BibliotecaApp();

        ArrayList<Book> bookList = bibliotec.makeBookList();
        LibraryLister library = new LibraryLister(bookList);
        ArrayList<MenuItem> options = bibliotec.makeMenuOptions();
        MainMenu mainMenu = new MainMenu(options, library);

        bibliotec.makeWelcome();
        mainMenu.printOptions(System.out);

        while(true){
            String command = bibliotec.chooseMenuOption().toUpperCase();
            mainMenu.runMenuOption(command);
        }

    }

    private ArrayList<Book> makeBookList(){
        Book b1 = new Book("War and Peace", "Leo Tolstoy", 1869);
        Book b2 = new Book("Crime and Punishment", "Fyodor Dostoyevsky", 1866);
        Book b3 = new Book("Lord of the Rings", "J.R.R Tolkein", 1954);
        bookList = new ArrayList<Book>();
        bookList.addAll(Arrays.asList(b1, b2, b3));
        return bookList;
    }

    private ArrayList<MenuItem> makeMenuOptions(){
        ListOption listBooks = new ListOption("List Books");
        CheckoutOption checkout = new CheckoutOption("Check Out");
        ReturnOption checkIn = new ReturnOption("Return");
        QuitOption quit = new QuitOption("Quit");
        options = new ArrayList<MenuItem>();
        options.addAll(Arrays.asList(listBooks, checkout, checkIn, quit));
        return options;
    }

    private void makeWelcome(){
        WelcomeMessage welcome = new WelcomeMessage(System.out);
        welcome.printMessage();
        System.out.println();
        System.out.println("MAIN MENU");
        System.out.println();
    }


    private String chooseMenuOption(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your menu option command (first letter(s)): ");
        return scanner.next();
    }

}
