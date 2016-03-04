package com.twu.biblioteca;

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
    }
}
