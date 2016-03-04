package com.twu.biblioteca;

import java.util.ArrayList;

/**
 * Created by nihughes on 04/03/2016.
 */
public class AccountOption implements MenuItem {

    private String optionName;

    public AccountOption(String optionName){
        this.optionName = optionName;
    }

    @Override
    public String getOptionName(){
        return  optionName;
    }

    @Override
    public void run(LibraryLister library, UserManager userManager){
        String details = userManager.getUserDetails();
        System.out.println(details);
        System.out.println();
        printUserItems(library, userManager);

    }

    private void printUserItems(LibraryLister library, UserManager userManager){
        User currentUser = userManager.getLoggedInUser();
        System.out.println("Checked out items");
        System.out.println("-----------------");
        ArrayList<LibraryItem> userItems = library.getUserItems(currentUser);
        for(LibraryItem userItem : userItems){
            userItem.printDetails(System.out);
        }
    }
}
