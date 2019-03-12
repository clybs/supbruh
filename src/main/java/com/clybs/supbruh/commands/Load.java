package com.clybs.supbruh.commands;

import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

import org.w3c.dom.Document;

public class Load implements Task {
    private String filename;
    private Document document;

    public static final String DEFAULT_FILENAME = "commands.xml";

    /**
     * Load is the constructor
     *
     * @param filename The filename to use
     */
    public Load(String filename) {
        // Set default filename
        setFilename(filename);
        System.out.println("Loading commands from file: " + this.filename);
    }

    @Override
    /**
     * execute will perform the operation
     */
    public void execute() {
        try {
            // Get the filename
            File inputFile = new File(filename);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

            // Set the document
            document = dBuilder.parse(inputFile);
        } catch (Exception e) {
            System.out.println("File not found: " + filename);
        }
    }

    /**
     * getDocument will return the {@link Document} object
     *
     * @return
     */
    public Document getDocument() {
        return document;
    }

    /**
     * getFilename will get the filename
     *
     * @return
     */
    public String getFilename() {
        return filename;
    }

    /**
     * setFilename will set the filename
     *
     * @param filename The filename to use
     */
    private void setFilename(String filename) {
        this.filename = DEFAULT_FILENAME;

        // Check if filename was defined
        if (filename != null && !filename.isEmpty()) {
            this.filename = filename;
        }
    }
}
