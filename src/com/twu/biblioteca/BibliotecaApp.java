package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class BibliotecaApp {

    static String chooseMenuOption(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your menu option command (first letter(s)): ");
        return scanner.next();
    }

    public static void main(String[] args) {

        WelcomeMessage welcome = new WelcomeMessage(System.out);
        welcome.printMessage();

        Book b1 = new Book("War and Peace", "Leo Tolstoy", 1869);
        Book b2 = new Book("Crime and Punishment", "Fyodor Dostoyevsky", 1866);
        Book b3 = new Book("Lord of the Rings", "J.R.R Tolkein", 1954);
        ArrayList<Book> bookList = new ArrayList<Book>();
        bookList.add(b1);
        bookList.add(b2);
        bookList.add(b3);
        LibraryLister library = new LibraryLister(bookList);
        System.out.println();
        System.out.println("MAIN MENU");
        System.out.println();
        ListOption listBooks = new ListOption("List Books");
        QuitOption quit = new QuitOption("Quit");
        CheckoutOption checkout = new CheckoutOption("Check Out");
        ArrayList<MenuItem> options = new ArrayList<MenuItem>();
        options.add(listBooks);
        options.add(quit);
        options.add(checkout);
        MainMenu mainMenu = new MainMenu(options, library);
        mainMenu.printOptions(System.out);
        while(true){
            String command = chooseMenuOption();
            mainMenu.runMenuOption(command, System.out);
        }

    }

}
