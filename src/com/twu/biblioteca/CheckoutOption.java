package com.twu.biblioteca;

/**
 * Created by nihughes on 03/03/2016.
 */
public class CheckoutOption implements MenuItem {

    private String optionName;

    public CheckoutOption(String optionName){
        this.optionName = optionName;
    }

    @Override
    public String getOptionName(){
        return  optionName;
    }

    @Override
    public void run(LibraryLister library, UserManager userManager){
        library.initiateCheckOut();
    }
}
