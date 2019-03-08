package com.clybs.supbruh.commands;

public class Process implements Task {
    @Override
    public void execute() {
        System.out.print(" And");
        System.out.println(" Processed.");
    }
}
