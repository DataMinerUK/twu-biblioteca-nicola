package com.twu.biblioteca;

import java.util.ArrayList;

public class BibliotecaApp {

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
        library.callDetails();
    }
}
