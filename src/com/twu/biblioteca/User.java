package com.twu.biblioteca;

/**
 * Created by nihughes on 04/03/2016.
 */
public class User {

    private String name;
    private String email;
    private String phone;
    private String libraryNumber;
    private String password;
    private boolean loggedIn;

    public User(String n, String e, String ph, String lN, String pw){
        this.name = n;
        this.email = e;
        this.phone = ph;
        this.libraryNumber = lN;
        this.password = pw;
        this.loggedIn = false;
    }

    public String getName(){
        return name;
    }
    public String getEmail(){
        return email;
    }
    public String getPhone(){
        return phone;
    }
    public String getLibraryNumber(){
        return libraryNumber;
    }
    public String getPassword(){
        return password;
    }
    public boolean isLoggedIn(){ return loggedIn; }

    public void logIn(){
        this.loggedIn = true;
    }

    public void logOut(){
        this.loggedIn = false;
    }
}
