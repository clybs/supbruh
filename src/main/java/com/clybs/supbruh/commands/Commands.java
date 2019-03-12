package com.clybs.supbruh.commands;

public class Commands {
    /**
     * Create commands based on an XML file
     *
     * @param filename The xml file to use
     */
    public Commands(String filename) {
        Load load = new Load(filename);
        Process process = new Process(load.getDocument());
        Command cmd = new Common(load, process);

        cmd.save();
    }
}
