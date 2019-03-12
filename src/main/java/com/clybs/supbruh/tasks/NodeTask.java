package com.clybs.supbruh.tasks;

public class NodeTask {
    private String name;
    private String description;
    private String letter;
    private NodeTask[] subtasks;

    public NodeTask(String name, String description, String letter) {
        this.name = name;
        this.description = description;
        this.letter = letter;
        this.subtasks = null;
    }

    public String getDescription() {
        return description;
    }

    public String getLetter() {
        return letter;
    }

    public String getName() {
        return name;
    }

    public NodeTask[] getSubtasks() {
        return subtasks;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setLetter(String letter) {
        this.letter = letter;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSubtasks(NodeTask[] subtasks) {
        this.subtasks = subtasks;
    }
}
