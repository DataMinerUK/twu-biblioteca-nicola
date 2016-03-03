package com.twu.biblioteca;


import java.io.PrintStream;
import java.util.ArrayList;

/**
 * Created by nihughes on 03/03/2016.
 */
public class MainMenu {

    private LibraryLister ll;
    private ArrayList<MenuItem> options;

    public MainMenu(ArrayList<MenuItem> options, LibraryLister ll){
        this.ll = ll;
        this.options = options;
    }

    public void printOptions(PrintStream ps){
        for(MenuItem o: options){
            ps.println(o.getOptionName());
        }
    }

    public void runMenuOption(String userInput){
        if(!isValidOption(userInput)){
            System.out.println("Select a valid option!");
        } else {
            for(MenuItem o: options) {
                if (userInput.equals(createCommand(o.getOptionName()))) {
                    o.run(ll);
                }
            }
        }
    }

    private boolean isValidOption(String userInput){
        ArrayList<String> commandList = makeListOfCommand();
        if(!commandList.contains(userInput)){
            return false;
        }
        return true;
    }

    private ArrayList<String> makeListOfCommand(){
        ArrayList<String> commandsList = new ArrayList<String>();
        for(MenuItem o: options){
            commandsList.add(createCommand(o.getOptionName()));
        }
        return commandsList;
    }

    private String createCommand(String input){
        String[] splitInput = input.split("\\s+");
        String command = "";
        for(String word: splitInput){
            String firstLetter = word.substring(0,1);
            command += firstLetter;
        }
        return command;
    }
}

