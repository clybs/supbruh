package com.clybs.supbruh.tasks;

import org.w3c.dom.*;

import java.util.ArrayList;

public class Process implements ITask {
    private Document document;
    private ArrayList<NodeTask> nodeTasks;

    /**
     * parse will look for tasks in the document
     */
    private void parse() {
        nodeTasks = new ArrayList<>();

        // Normalize and start fetching
        document.getDocumentElement().normalize();
        NodeList nList = document.getElementsByTagName("task");

        // Get the required items
        for (int i = 0; i < nList.getLength(); i++) {
            Node nNode = nList.item(i);
            String currentElement = nNode.getNodeName();

            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;

                String taskName = eElement.getAttribute("name");
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

                // Prepare the conditions for a command to be added
                boolean currentElementIsCommand = currentElement == "task";
                boolean commandNameFound = taskName != null && !taskName.isEmpty();
                boolean descriptionFound = description != null && !description.isEmpty();
                boolean letterFound = letter != null && !letter.isEmpty();
                boolean aliasFound = alias != null && !alias.isEmpty();

                // Check if command can be added
                if (currentElementIsCommand && commandNameFound && descriptionFound &&
                        letterFound && aliasFound) {
                    // Create a nodeTask
                    NodeTask nodeTask = new NodeTask(taskName, description, letter);

                    // Add it to existing nodeTasks
                    nodeTasks.add(nodeTask);
                }
            }
        }
    }

    @Override
    /**
     * execute will perform the operation
     */
    public void execute() {
        // Parse the document
        parse();
        System.out.print(" And");
        System.out.println(" Processed.");
    }

    /**
     * getDocument will get the document
     *
     * @return
     */
    public Document getDocument() {
        return document;
    }

    /**
     * getNodeTasks will get the nodeTasks
     *
     * @return
     */
    public ArrayList<NodeTask> getNodeTasks() {
        return nodeTasks;
    }

    /**
     * setDocument will set the document
     *
     * @param document The document to use
     */
    public void setDocument(Document document) {
        this.document = document;
    }
}
