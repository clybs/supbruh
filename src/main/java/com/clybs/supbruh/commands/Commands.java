package com.clybs.supbruh.commands;

public class Commands {
    /**
     * Create commands based on an XML file
     * @param filename The xml file to use
     */
    public Commands(String filename) {
        Command cmd = new Common(new Load(filename), new Process());
        cmd.save();
    }
}
