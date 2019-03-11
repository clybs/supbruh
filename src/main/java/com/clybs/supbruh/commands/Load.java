package com.clybs.supbruh.commands;

import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class Load implements Task {
    private String filename;
    public static final String DEFAULT_FILENAME = "commands.xml";

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
        try {
            // Get the filename
            File inputFile = new File(this.filename);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
            NodeList nList = doc.getElementsByTagName("student");
            System.out.println("----------------------------");

        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.print("Loaded");
    }

    public String getFilename() {
        return filename;
    }
}
