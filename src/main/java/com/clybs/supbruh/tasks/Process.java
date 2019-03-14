package com.clybs.supbruh.tasks;

import org.w3c.dom.*;

import java.util.ArrayList;

public class Process implements ITask {
    private Document document;
    private String taskGroupName;
    private ArrayList<NodeTask> nodeTasks;

    /**
     * parse will look for tasks in the document
     */
    private void parse() {
        nodeTasks = new ArrayList<>();

        try {
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

                    // Prepare the conditions for a command to be added
                    boolean currentElementIsCommand = currentElement == "task";
                    boolean commandNameFound = taskName != null && !taskName.isEmpty();
                    boolean descriptionFound = description != null && !description.isEmpty();

                    // Check if command can be added
                    if (currentElementIsCommand && commandNameFound && descriptionFound) {
                        // Create a nodeTask
                        NodeTask nodeTask = new NodeTask(taskName, description, taskGroupName);

                        // Add it to existing nodeTasks
                        nodeTasks.add(nodeTask);
                    }
                }
            }
        } catch (NullPointerException npe) {
            // Check if there is a message
            if (npe.getLocalizedMessage() != null) {
                System.out.println(npe.getLocalizedMessage());
            }

            // Exit program
            System.exit(1);
        }
    }

    @Override
    /**
     * execute will perform the operation
     */
    public void execute() {
        // Parse the document
        parse();
        System.out.println("Processed task group: " + taskGroupName);
    }

    /**
     * getTaskGroupName will get the task group name
     *
     * @return
     */
    public String getTaskGroupName() {
        return taskGroupName;
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

    /**
     * setTaskGroupName will set the task group name
     *
     * @param taskGroupName The task group name to use
     */
    public void setTaskGroupName(String taskGroupName) {
        this.taskGroupName = taskGroupName;
    }
}
