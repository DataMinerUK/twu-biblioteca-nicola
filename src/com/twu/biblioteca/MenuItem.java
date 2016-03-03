package com.twu.biblioteca;

/**
 * Created by nihughes on 03/03/2016.
 */
public interface MenuItem {

    public abstract String getOptionName();
    public abstract void run(LibraryLister library);

}
