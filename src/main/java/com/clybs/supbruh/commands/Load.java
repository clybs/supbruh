package com.clybs.supbruh.commands;

import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

import org.apache.commons.cli.Options;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class Load implements Task {
    private String filename;
    private Options options;

    public static final String DEFAULT_FILENAME = "commands.xml";

    public Load(String filename) {
        // Set default filename
        setFilename(filename);
        System.out.println("Loading commands from file: " + this.filename);
    }

    @Override
    public void execute() {
        options = new Options();

        try {
            // Get the filename
            File inputFile = new File(filename);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName("command");

            for (int i = 0; i < nList.getLength(); i++) {
                Node nNode = nList.item(i);

                String currentElement = nNode.getNodeName();

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;

                    String commandName = eElement.getAttribute("name");
                    String description = eElement.getElementsByTagName("description")
                            .item(0)
                            .getTextContent();
                    String letter = eElement
                            .getElementsByTagName("letter")
                            .item(0)
                            .getTextContent();
                    String alias = eElement
                            .getElementsByTagName("alias")
                            .item(0)
                            .getTextContent();
                    String paramRequired = eElement
                            .getElementsByTagName("paramRequired")
                            .item(0)
                            .getTextContent();
                    boolean paramRequiredConverted = Boolean.parseBoolean(paramRequired);

                    // Prepare the conditions for a command to be added
                    boolean currentElementIsCommand = currentElement == "command";
                    boolean commandNameFound = commandName != null && !commandName.isEmpty();
                    boolean descriptionFound = description != null && !description.isEmpty();
                    boolean letterFound = letter != null && !letter.isEmpty();
                    boolean aliasFound = alias != null && !alias.isEmpty();
                    boolean paramRequiredFound = paramRequired != null && !paramRequired.isEmpty();

                    // Check if command can be added
                    if (currentElementIsCommand && commandNameFound && descriptionFound &&
                            letterFound && aliasFound && paramRequiredFound) {
                        options.addOption(letter, alias, paramRequiredConverted, description);
                    }
                }
            }

        } catch (Exception e) {
            System.out.println("File not found: " + filename);
        }
    }

    private void setFilename(String filename) {
        this.filename = DEFAULT_FILENAME;

        // Check if filename was defined
        if (filename != null && !filename.isEmpty()) {
            this.filename = filename;
        }
    }

    public String getFilename() {
        return filename;
    }

    public Options getOptions() {
        return options;
    }
}
