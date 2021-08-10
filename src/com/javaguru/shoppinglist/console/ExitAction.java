package com.javaguru.shoppinglist.console;

public class ExitAction implements Action{

    private final static String ACTION_NAME = "Exit";
    @Override
    public void execute() {
        System.exit(0);
    }

    @Override
    public String toString() {
        return ACTION_NAME;
    }
}
