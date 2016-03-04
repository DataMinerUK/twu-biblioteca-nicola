package com.twu.biblioteca;

import java.util.ArrayList;

/**
 * Created by nihughes on 04/03/2016.
 */
public class UserManager {

    private ArrayList<User> userList;

    public UserManager(ArrayList<User> u){
        this.userList = u;
    }

    public boolean canUserLogIn(String libraryNumber, String password){
        for(User u : userList){
            if(userVerified(u, libraryNumber, password)) {
                u.logIn();
                return true;
            }
        }
        return false;
    }

    public void logOutUser(){
        for(User u : userList){
            if(u.isLoggedIn()){
                u.logOut();
            }
        }
    }

    public String getUserDetails(){
        String details = "No user currently logged in";
        for(User u : userList){
            if(u.isLoggedIn()){
                details = "Name: "+ u.getName() +"\nEmail: "+ u.getEmail() +"\nPhone number: "+ u.getPhone();
            }
        }
        return details;
    }

    private boolean userVerified(User user, String libraryNumber, String password){
        return user.getLibraryNumber().equals(libraryNumber) && user.getPassword().equals(password);
    }
}
