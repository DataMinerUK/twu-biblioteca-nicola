package com.twu.biblioteca;

/**
 * Created by nihughes on 03/03/2016.
 */
public class ListOption implements MenuItem {

    private String optionName;

    public ListOption(String optionName){
        this.optionName = optionName;
    }

    @Override
    public String getOptionName(){
        return  optionName;
    }

    @Override
    public void run(LibraryLister library, UserManager userManager){
        library.callDetails();
    }
}
