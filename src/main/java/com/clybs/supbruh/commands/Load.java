package com.clybs.supbruh.commands;

public class Load implements Task {
    public static final String DEFAULT_FILENAME = "commands.xml";
    private String filename;

    public Load(String filename) {
        // set default filename
        this.filename = DEFAULT_FILENAME;

        // Check if filename was defined
        if (filename != null && !filename.isEmpty()) {
            this.filename = filename;
        }
    }

    @Override
    public void execute() {
        System.out.print("Loaded");
    }

    public String getFilename() {
        return filename;
    }
}
