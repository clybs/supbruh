package com.clybs.supbruh.commands;

public class Commands {
    public Commands() {
        Command cmd = new Common(new Load(null), new Process());
        cmd.save();
    }
}
