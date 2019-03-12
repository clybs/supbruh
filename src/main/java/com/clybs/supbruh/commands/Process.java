package com.clybs.supbruh.commands;

import org.apache.commons.cli.Options;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class Process implements Task {
    private Options options;

    /**
     * Process the document
     *
     * @param document the {@link Document} object
     */
    public Process(Document document) {
        // Set the new options
        options = new Options();

        // Normalize and start fetching
        document.getDocumentElement().normalize();
        NodeList nList = document.getElementsByTagName("command");

        // Get the required items
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
    }

    @Override
    /**
     * execute will perform the operation
     */
    public void execute() {
        System.out.print(" And");
        System.out.println(" Processed.");
    }

    /**
     * getOptions will get the options
     *
     * @return
     */
    public Options getOptions() {
        return options;
    }
}
