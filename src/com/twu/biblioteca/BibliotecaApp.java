package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class BibliotecaApp {

    private ArrayList<MenuItem> options;
    private ArrayList<LibraryItem> libraryList;
    private ArrayList<User> users;

    public static void main(String[] args) {
        BibliotecaApp bibliotec = new BibliotecaApp();
        bibliotec.go();
    }

    public void go(){
        users = makeUserList();
        UserManager userManager = new UserManager(users);
        libraryList = makeLibraryList();
        LibraryLister library = new LibraryLister(libraryList);
        options = makeMenuOptions();
        MainMenu mainMenu = new MainMenu(options, library, userManager);

        String libraryNumber = askForLibraryNumber();
        String password = askForPassword();

        while(!userManager.canUserLogIn(libraryNumber, password)){
            libraryNumber = askForLibraryNumber();
            password = askForPassword();
            userManager.canUserLogIn(libraryNumber, password);
        }

        makeWelcome();
        mainMenu.printOptions(System.out);

        while(true){
            String command = chooseMenuOption().toUpperCase();
            mainMenu.runMenuOption(command);
        }
    }

    private ArrayList<User> makeUserList(){
        User u1 = new User("Nicola", "nicola@email.com", "555 123456", "123-4567", "password");
        User u2 = new User("Rose", "rose@email.com", "555 555555", "555-5555", "password5");
        ArrayList<User> users = new ArrayList<User>();
        users.addAll(Arrays.asList(u1, u2));
        return users;
    }

    private ArrayList<LibraryItem> makeLibraryList(){
        Book b1 = new Book("War and Peace", "Leo Tolstoy", 1869);
        Book b2 = new Book("Crime and Punishment", "Fyodor Dostoyevsky", 1866);
        Book b3 = new Book("Lord of the Rings", "J.R.R Tolkein", 1954);
        Movie m1 = new Movie("City of God", "Fernando Meirelles", 2003, 5);
        Movie m2 = new Movie("The Usual Suspects", "Bryan Singer", 1995, 5);
        Movie m3 = new Movie("Amelie", "Jean-Pierre Jeunet", 2001, 5);
        ArrayList<LibraryItem> libraryList = new ArrayList<LibraryItem>();
        libraryList.addAll(Arrays.asList(b1, b2, b3, m1, m2, m3));
        return libraryList;
    }

    private ArrayList<MenuItem> makeMenuOptions(){
        ListOption listBooks = new ListOption("List");
        CheckoutOption checkout = new CheckoutOption("Checkout");
        ReturnOption checkIn = new ReturnOption("Return");
        QuitOption quit = new QuitOption("Quit");
        ArrayList<MenuItem> options = new ArrayList<MenuItem>();
        options.addAll(Arrays.asList(listBooks, checkout, checkIn, quit));
        return options;
    }

    private String askForLibraryNumber(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your library number: ");
        return scanner.next();
    }

    private String askForPassword(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your password: ");
        return scanner.next();
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
        System.out.println("Enter your menu option command (first letter): ");
        return scanner.next();
    }

}
